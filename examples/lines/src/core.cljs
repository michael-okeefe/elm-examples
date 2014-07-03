(ns lines.core
  "Draw lines on a canvas:
  http://elm-lang.org/edit/examples/Elements/Lines.elm"
  (:require [om.core :as om :include-macros true]
            [om.dom :as dom :include-macros true]))

(defn draw
  [cursor owner color dashed? x y dom-ref-str]
  (let [canvas (om/get-node owner dom-ref-str)
        ctxt (.getContext canvas "2d")]
    (set! (.-strokeStyle ctxt) color)
    (if dashed?
      (.setLineDash ctxt #js [8, 2])
      (.setLineDash ctxt #js []))
    (.strokeRect ctxt x y 100 100)))

(defn <fn>
  [cursor owner]
  (reify
    om/IDidMount
    (did-mount [_]
      (draw cursor owner "#3465a4" true 50 160 "drawing-board")
      (draw cursor owner "#cc0000" false 50 40 "drawing-board"))
    om/IRender
    (render [_]
      (dom/div #js {:style #js {:width "200px" :height "420px"
                                :padding "0px" :margin "0px"
                                :overflow "hidden"}}
               (dom/canvas #js {:width "200px"
                                :height "420px"
                                :ref "drawing-board"
                                :style #js {:padding "0px"
                                            :margin "0px"
                                            :display "block"
                                            :position "absolute"}})))))

(om/root <fn> {} {:target (.getElementById js/document "app")})
