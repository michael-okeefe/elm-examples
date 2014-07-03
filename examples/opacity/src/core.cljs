(ns opacity.core
  "Change the opacity of an image:
  http://elm-lang.org/edit/examples/Elements/Opacity.elm"
  (:require [om.core :as om :include-macros true]
            [om.dom :as dom :include-macros true]))

(defn <fn>
  [cursor owner]
  (reify
    om/IRender
    (render [_]
      (dom/div #js {:style #js {:padding "0px"
                                :margin "0px"
                                :-webkit-background-size "cover"
                                :width "300px"
                                :height "200px"
                                :opacity "0.5"
                                :background-color "transparent"
                                :background-image "url(\"rocks.jpg\")"
                                :background-position-x "50%"
                                :background-position-y "50%"
                                :background-size "cover"
                                :background-repeat "no-repeat"}}))))

(om/root <fn> {} {:target (.getElementById js/document "app")})
