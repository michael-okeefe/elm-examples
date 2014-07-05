(ns transforms.core
  "Based on the code here:
  http://elm-lang.org/edit/examples/Elements/Transforms.elm"
  (:require [om.core :as om :include-macros true]
            [om.dom :as dom :include-macros true]))

(enable-console-print!)

;; colors from http://tango.freedesktop.org/Tango_Icon_Theme_Guidelines
(def purple "#75507b")
(def green "#73d216")
(def blue "#3465a4")
(def red "#cc0000")
(def black "#000")
(def tau (* 2.0 (.-PI js/Math)))

(def default-line-style
  {:color black
   :width 1
   :cap "flat"
   :join "round"
   :dashing []
   :dash-offset 0})

(defn form
  [basic-form]
  {:theta 0
   :scale 1
   :x 0
   :y 0
   :alpha 1
   :form basic-form})

(defn ngon
  "(Fn [Int Float]
       (Vector (Tuple Float Float)))
  A regular polygon with n sides"
  [number-of-sides radius]
  (let [m (float number-of-sides)
        t (/ (* 2.0 (.-PI js/Math))
             m)
        f (fn [i] [(* radius (.cos js/Math (* t i)))
                   (* radius (.sin js/Math (* t i)))])]
    (mapv f (range number-of-sides))))

(defn solid
  "(Fn [Color] LineStyle)
  Set the line color"
  [color]
  (assoc default-line-style :color color))

(defn outlined
  "(Fn [LineStyle Shape] Form)
  Create a form with outline styling"
  [line-style shape]
  (form {:type :form-shape
         :style line-style
         :shape shape}))

(defn hexagon
  "(Fn [Color] Shape)
  Create a 6-sided polygon of the given color"
  [color]
  (outlined (solid color)
            (ngon 6 40)))

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
    (.translate ctxt 150 150)
    (when (or (not= x 0) (not= y 0))
      (.translate ctxt x y))
    (when (not= theta 0)
      (.rotate ctxt theta))
    (when (not= scale 1)
      (.scale ctxt scale scale))
    (.scale ctxt 1 -1)
    (set! (.-strokeStyle ctxt) (:color style))
    (set! (.-lineCap ctxt) (:cap style))
    (set! (.-lineJoin ctxt) (:join style))
    (.beginPath ctxt)
    (let [[last-x last-y] (last shape)]
      (.moveTo ctxt last-x last-y))
    (doseq [[x y] shape]
      (.lineTo ctxt x y))
    (.closePath ctxt)
    (.stroke ctxt)
    (.restore ctxt)))

(defn <fn>
  [cursor owner]
  (reify
    om/IDidMount
    (did-mount [_]
      (let [ctxt (get-context owner "drawing-board")
            shape1 (hexagon red)
            shape2 (scale 2 (hexagon purple))
            shape3 (move [100 0] (hexagon green))
            shape4 (rotate (degrees 30) (hexagon blue))]
        (draw ctxt shape1)
        (draw ctxt shape2)
        (draw ctxt shape3)
        (draw ctxt shape4)))
    om/IRender
    (render [_]
      (dom/div #js {:style #js {:width "300px" :height "300px"}}
               (dom/canvas #js {:width "300px" :height "300px"
                                :ref "drawing-board"})))))

(om/root <fn> {} {:target (.getElementById js/document "app")})
