(ns text.core
  "Example of rendering Text:
  http://elm-lang.org/edit/examples/Elements/Text.elm"
  (:require [om.core :as om :include-macros true]
            [om.dom :as dom :include-macros true]))

(defn <fn>
  [cursor owner]
  (reify
    om/IRender
    (render [_]
      (dom/div nil
               (dom/div #js {:style #js {:padding "0px"
                                         :margin "0px"
                                         :width "54px"
                                         :height "54px"}}
                        (dom/div #js {:style #js {:padding "0px"
                                                  :margin "0px"
                                                  :visibility "visible"
                                                  :text-align "left"
                                                  :pointer-events "auto"
                                                  :width "36px"
                                                  :height "18px"}}
                                 (dom/span #js {:style #js {:font-weight "bold"}} "Bold"))
                        (dom/div #js {:style #js {:padding "0px"
                                                  :margin "0px"
                                                  :visibility "visible"
                                                  :text-align "left"
                                                  :pointer-events "auto"
                                                  :width "54px"
                                                  :height "18px"}}
                                 (dom/span #js {:style #js {:font-style "italic"}} "Italicize"))
                        (dom/div #js {:style #js {:padding "0px"
                                                  :margin "0px"
                                                  :visibility "visible"
                                                  :text-align "left"
                                                  :pointer-events "auto"
                                                  :width "30px"
                                                  :height "18px"}}
                                 (dom/a #js {:href "/"} "Link")))))))

(om/root <fn> {} {:target (.getElementById js/document "app")})
