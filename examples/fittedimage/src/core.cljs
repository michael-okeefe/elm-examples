(ns fittedimage.core
  "Example of displaying a ``fitted image'' as per Elm's
  FittedImage.elm example:
  http://elm-lang.org/edit/examples/Elements/FittedImage.elm"
  (:require [om.core :as om :include-macros true]
            [om.dom :as dom :include-macros true]))

(defn fitted-image
  [cursor owner]
  (reify
    om/IRender
    (render [_]
      (dom/div nil
               (dom/div #js {:style #js {:padding "0px"
                                         :margin "0px"
                                         :-webkit-background-size "cover"
                                         :width "300px"
                                         :height "300px"
                                         :background-image "url(\"rocks.jpg\")"
                                         :background-repeat "no-repeat"
                                         :background-position "50% 50%"}})))))

(om/root fitted-image {} {:target (.getElementById js/document "app")})
