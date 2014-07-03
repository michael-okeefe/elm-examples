(ns typeface.core
  "Example of specifying the typeface:
  http://elm-lang.org/edit/examples/Elements/Typeface.elm"
  (:require [om.core :as om :include-macros true]
            [om.dom :as dom :include-macros true]))

(defn spec-typeface
  [font-family]
  (dom/div #js {:style #js {:text-align "left"}}
           (dom/span #js {:style #js {:font-family font-family}}
                     (dom/br nil)
                     "The quick brown fox jumps over the lazy dog."
                     (dom/br nil))))

(defn <fn>
  [cursor owner]
  (reify
    om/IRender
    (render [_]
      (apply dom/div nil
             (map spec-typeface
                  ["times new roman"
                   "helvetica, sans-serif"
                   "georgia, serif"
                   "trebuchet ms, sans-serif"
                   "inconsolata, courier new, monospace"])))))

(om/root <fn> {} {:target (.getElementById js/document "app")})
