(ns shapes.core
  "Shapes example based on:
  http://elm-lang.org/edit/examples/Elements/Shapes.elm"
  (:require [om.core :as om :include-macros true]
            [om.dom :as dom :include-macros true]))

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

(defn get-context
  [owner canvas-id]
  (let [canvas (om/get-node owner canvas-id)]
    (.getContext canvas "2d")))

(defn draw-ngon
  [ctxt [x y] xys]
  (let [grey "rgba(111,111,111,0.6)"]
    (.beginPath ctxt)
    (.moveTo ctxt x y)
    (let [[last-x last-y] (last xys)]
      (.moveTo ctxt (+ x last-x) (+ y last-y)))
    (doseq [[xpt ypt] xys]
      (.lineTo ctxt (+ x xpt) (+ y ypt)))
    (.closePath ctxt)
    (set! (.-fillStyle ctxt) grey)
    (.fill ctxt)))

(defn <fn>
  [cursor owner]
  (reify
    om/IDidMount
    (did-mount [_]
      (let [ctxt (get-context owner "my-canvas")]
        (draw-ngon ctxt [80 100] (ngon 4 75.0))
        (draw-ngon ctxt [160 110] (ngon 5 50.0))))
    om/IRender
    (render [_]
      (dom/div nil
               (dom/canvas #js {:ref "my-canvas"
                                :width "300px"
                                :height "300px"})))))

(om/root <fn> {} {:target (.getElementById js/document "app")})
