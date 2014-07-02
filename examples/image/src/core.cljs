(ns image.core
  "Example of rendering images via Om. Based on:
  http://elm-lang.org/edit/examples/Elements/Image.elm"
  (:require [om.core :as om :include-macros true]
            [om.dom :as dom :include-macros true]))

(def style #js {:padding "0px"
                :margin "0px"
                :display "block"
                :width "472px"
                :height "396px"})

(defn show-image
  [cursor owner]
  (reify
    om/IRender
    (render [_]
            (dom/div nil
                     (dom/img #js {:src "rocks.jpg"
                                   :alt "Picture of some awesome rocks!"
                                   :name "rocks.jpg"
                                   :style style})))))

(om/root show-image {} {:target (.getElementById js/document "app")})
