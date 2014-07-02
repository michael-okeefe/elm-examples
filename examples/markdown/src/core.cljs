(ns markdown.core
  "Example of using Markdown to render to an Om component. Based on:
  http://elm-lang.org/edit/examples/Elements/Markdown.elm"
  (:require [om.core :as om :include-macros true]
            [om.dom :as dom :include-macros true]))

;; Note that there is not currently an obvious way to go from Markdown to React
;; DOM elements -- if someone knows otherwise, please open an issue or create a
;; pull request. The objective of this project in porting Elm code to Om is to
;; explore "how to get more or less the same output on the screen as each Elm
;; program" so in this exercise I literally translate Markdown into React/dom
;; elements by hand. Note below that markdown-comp is a function that must
;; return an instance of om/IRender or om/IRenderState. dom/div does this for
;; us.
(defn markdown-comp
  [cursor owner]
  (dom/div nil
           (dom/h1 nil "Markdown Support")
           (dom/p nil (str "Om does not (yet) have native markdown support, "
                           "but you can still easily make:"))
           (dom/ul nil
                   (dom/li nil "Headers")
                   (dom/li nil (dom/a #js {:href "/"} "Links"))
                   (dom/li nil "Images")
                   (dom/li nil
                           (dom/b nil "Bold") ", "
                           (dom/i nil "italic") ", and "
                           (dom/code nil "monospaced") " text")
                   (dom/li nil "Lists (numbered, nested, multi-paragraph "
                           "bullets)"))
           (dom/p nil (str "It all feels quite natural to type (?). For more "
                           "information on Markdown, see ")
                  (dom/a
                   #js {:href "http://daringfireball.net/projects/markdown/"}
                   "this site")
                  ".")))

(om/root markdown-comp {} {:target (.getElementById js/document "app")})
