(ns color.core
  "Om version of the Elm code here:
  http://elm-lang.org/edit/examples/Elements/Color.elm"
  (:require [om.core :as om :include-macros true]
            [om.dom :as dom :include-macros true]))

(enable-console-print!)

;; Of course use TAU, not PI...
;; http://www.tauday.com/
(def tau (* 2.0 (.-PI js/Math)))

(defn form
  [basic-form]
  {:theta 0
   :scale 1
   :x 0
   :y 0
   :alpha 1
   :form basic-form})

(defn fmod
  [f n]
  (let [integer (.floor js/Math f)]
    (- (+ (mod integer n) f) integer)))

(defn hsl-to-rgb
  [{:keys [hue saturation lightness]}]
  (let [chroma (- 1 (* (.abs js/Math (- (* 2 lightness) 1))
                       saturation))
        hue-alt (/ hue (degrees 60))
        x (* chroma (- 1 (.abs js/Math (- (fmod hue-alt 2) 1))))
        [r g b] (condp > hue-alt
                  0 [0 0 0]
                  1 [chroma x 0]
                  2 [x chroma 0]
                  3 [0 chroma x]
                  4 [0 x chroma]
                  5 [x 0 chroma]
                  6 [chroma 0 x]
                  [0 0 0])
        m (- lightness (/ chroma 2))]
    [(+ r m)
     (+ g m)
     (+ b m)]))

(defn rgb-to-str
  [[r g b]]
  (str "rgb(" (.round js/Math (* 255 r))
       ", " (.round js/Math (* 255 g))
       ", " (.round js/Math (* 255 b)) ")"))

(defn hsl
  [hue saturation lightness]
  {:hue (- hue (.floor js/Math (/ hue (* 2 (.-PI js/Math)))))
   :saturation saturation
   :lightness lightness})

(defn filled
  [color shape]
  (form {:style color :shape shape}))

(defn scale
  "(Fn [Float Form] Form)
  Adjust the scale factor"
  [scale-factor form]
  (update-in form [:scale] * scale-factor))

(defn degrees
  "(Fn [Float] Float)
  Returns the angle in radians corresponding
  to the given degrees"
  [deg]
  (* (/ deg 360.0) tau))

(defn rotate
  "(Fn [Float Form] Form)
  Adjust the rotation of the given form"
  [angle-in-rad form]
  (update-in form [:theta] + angle-in-rad))

(defn move-right-by
  "(Fn [Float Form] Float)"
  [amount form]
  (update-in form [:x] + amount))

(defn move-up-by
  "(Fn [Float Form] Float)"
  [amount form]
  (update-in form [:y] + amount))

(defn move
  "(Fn [[Float Float] Form] Form)
  Move the form relative to its current position
  by the given amounts to the right (x) and up (y)"
  [[right-by up-by] form]
  (->> form
       (move-right-by right-by)
       (move-up-by up-by)))

(defn oval
  "(Fn [Float Float] Shape)
  Create the path for an oval"
  [w h]
  (let [n 50
        t (/ tau n)
        hw (/ w 2)
        hh (/ h 2)
        f (fn [i] [(* hw (.cos js/Math (* t i)))
                   (* hh (.sin js/Math (* t i)))])]
    (mapv f (range n))))

(defn circle
  "(Fn [Float] Shape)
  Create a circle"
  [r]
  (let [diameter (* 2 r)]
    (oval diameter diameter)))

(defn get-context
  [owner canvas-id]
  (let [canvas (om/get-node owner canvas-id)]
    (.getContext canvas "2d")))

(defn draw
  "(Fn [Graphics2D Form] nil)
  Draw the given form on the screen"
  [ctxt form]
  (let [{:keys [theta scale x y alpha] {:keys [shape style]} :form} form]
    (.save ctxt)
    ;; place the image in the center of the space by default
    (.translate ctxt 150 150)
    (when (or (not= x 0) (not= y 0))
      (.translate ctxt x y))
    (when (not= theta 0)
      (.rotate ctxt theta))
    (when (not= scale 1)
      (.scale ctxt scale scale))
    (.scale ctxt 1 -1)
    (set! (.-fillStyle ctxt) style)
    (.beginPath ctxt)
    (let [[last-x last-y] (last shape)]
      (.moveTo ctxt last-x last-y))
    (doseq [[x y] shape]
      (.lineTo ctxt x y))
    (.closePath ctxt)
    (.fill ctxt)
    (.restore ctxt)))

(defn <fn>
  [cursor owner]
  (reify
    om/IDidMount
    (did-mount [_]
      (let [ctxt (get-context owner "drawing-board")]
        (doseq [n (range 12)]
          (let [angle (degrees (* 30 n))
                c (->> (circle 10)
                       (filled (rgb-to-str (hsl-to-rgb (hsl angle 0.7 0.5))))
                       (move [(* 45 (.cos js/Math angle)) (* 45 (.sin js/Math angle))]))]
            (draw ctxt c)))))
    om/IRender
    (render [_]
      (dom/div #js {:style #js {:width "300px" :height "300px"}}
               (dom/canvas #js {:width "300px" :height "300px"
                                :ref "drawing-board"})))))

(om/root <fn> {} {:target (.getElementById js/document "app")})
