# parent
Clojure and NPM parent package definitions

## In Clojure
```clojure
  :plugins [[lein-parent "0.3.5"]]
  :parent-project {:coords [io.jesi/parent "0.0.1"]
                   :inherit [:plugins :repositories :managed-dependencies :dependencies :exclusions [:profiles :dev] :test-refresh]}
```

## In Javascript
```javascript
{
  ...
  "dry": {
    "extends": "@io.jesi/parent/package-dry.json",
    "dependencies": {
      "@io.jesi/parent": "0.0.1"
    }
  },
  "devDependencies": {
    "karma": "managed",
    "karma-chrome-launcher": "managed",
    "karma-cljs-test": "managed",
    "shadow-cljs": "managed",
    "standard": "managed"
  },
  ...
}
```
