(ns size.core
  "Changing the size of an element:
  http://elm-lang.org/edit/examples/Elements/Size.elm"
  (:require [om.core :as om :include-macros true]
            [om.dom :as dom :include-macros true]))

(defn change-size
  [cursor owner]
  (reify
    om/IRender
    (render [_]
      (dom/div nil
               (dom/img #js {:src "rocks.jpg"
                             :name "rocks.jpg"
                             :style #js {:padding "0px"
                                         :margin "0px"
                                         :display "block"
                                         :width "300px"
                                         :height "200px"}})))))

(om/root change-size {} {:target (.getElementById js/document "app")})
