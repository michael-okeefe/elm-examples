(ns layers.core
  "Layer elements on top of each other:
  http://elm-lang.org/edit/examples/Elements/Layers.elm"
  (:require [om.core :as om :include-macros true]
            [om.dom :as dom :include-macros true]))

(defn <fn>
  [cursor owner]
  (reify
    om/IRender
    (render [_]
      (dom/div #js {:style #js {:width "320px" :height "180px"}}
               (dom/div #js {:style #js {:padding "0px"
                                         :margin "0px"
                                         :-webkit-background-size "cover"
                                         :width "320px"
                                         :height "180px"
                                         :position "absolute"
                                         :background-image "url(\"waves.jpg\")"
                                         :background-repeat "no-repeat"
                                         :background-size "cover"
                                         :background-position-x "50%"
                                         :background-position-y "50%"
                                         :background-color "transparent"}})
               (dom/div #js {:style #js {:padding "0px"
                                         :margin-left "45px"
                                         :margin-top "10px"
                                         :width "320px"
                                         :text-align "left"
                                         :color "#fff"
                                         :visibility "visible"
                                         :position "absolute"}}
                        "She sells sea shells.")))))

(om/root <fn> {} {:target (.getElementById js/document "app")})
