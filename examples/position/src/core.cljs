(ns position.core
  "Positioning example:
  http://elm-lang.org/edit/examples/Elements/Position.elm"
  (:require [om.core :as om :include-macros true]
            [om.dom :as dom :include-macros true]))

;; Note: centering from here:
;; http://css-tricks.com/centering-in-the-unknown/
(defn <fn>
  [cursor owner]
  (reify
    om/IRender
    (render [_]
      (dom/div #js {:className "block"
                    :style #js {:padding "0px"
                                :margin "0px"
                                :width "300px"
                                :height "300px"
                                :background-color "rgb(211,215,207)"}}
               (dom/div #js {:className "centered"}
                        "tried this with HTML (and Om/React ;-)")))))

(om/root <fn> {} {:target (.getElementById js/document "app")})
