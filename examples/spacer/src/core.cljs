(ns spacer.core
  "Creation of a 'spacer' object:
  http://elm-lang.org/edit/examples/Elements/Spacer.elm"
  (:require [om.core :as om :include-macros true]
            [om.dom :as dom :include-macros true]))

(defn <fn>
  [cursor owner]
  (reify
    om/IRender
    (render [_]
      (dom/div #js {:style #js {:padding "0px" :margin "0px"
                                :width "30px" :height "30px"
                                :background-color "rgb(204, 0, 0)"}}))))

(om/root <fn> {} {:target (.getElementById js/document "app")})
