# parent
Clojure and NPM parent package definitions

```clojure
  :plugins [[lein-parent "0.3.4"]]
  :parent-project {:coords [io.jesi/parent "1.0.0"]
                   :inherit [:plugins :repositories :managed-dependencies :dependencies :exclusions [:profiles :dev] :test-refresh]}
```
