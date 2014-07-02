(ns croppedimage.core
  "Image cropping example based on:
  http://elm-lang.org/edit/examples/Elements/CroppedImage.elm"
  (:require [om.core :as om :include-macros true]
            [om.dom :as dom :include-macros true]))

(defn crop-image
  [image-name
   [x y :as top-left]
   [width height :as cropped-size]
   [orig-width orig-height :as orig-size]]
  (dom/div #js {:style #js {:padding "0px"
                            :margin "0px"
                            :overflow "hidden"
                            :width (str width "px")
                            :height (str height "px")}}
           (dom/img #js {:src image-name
                         :name image-name
                         :style #js {:padding "0px"
                                     :margin-top (str "-" y "px")
                                     :margin-right "0px"
                                     :margin-bottom "0px"
                                     :margin-left (str "-" x "px")
                                     :width (str orig-width "px")
                                     :height (str orig-height "px")}})))

(defn render-img
  [cursor owner]
  (reify
    om/IRender
    (render [_]
      (crop-image "rocks.jpg" [196 372] [200 100] [396 472]))))

(om/root render-img {} {:target (.getElementById js/document "app")})
