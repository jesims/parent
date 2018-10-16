# Parent
Clojure and NPM parent package definitions

## Latest Version

[![Clojars Project](https://img.shields.io/clojars/v/io.jesi/parent.svg)](https://clojars.org/io.jesi/parent)
[![NPM Version](https://img.shields.io/npm/v/@io.jesi/parent.svg)](https://img.shields.io/npm/v/@io.jesi/parent.svg)
[![CircleCI](https://circleci.com/gh/jesims/parent.svg?style=svg)](https://circleci.com/gh/jesims/parent)

## In Clojure
```clojure
  :plugins [[lein-parent "0.3.5"]]
  :parent-project {:coords [io.jesi/parent "X.Y.Z"]
                   :inherit [:plugins :repositories :managed-dependencies :dependencies :exclusions [:profiles :dev] :test-refresh]}
```

## In Javascript
```javascript
{
  ...
  "dry": {
    "extends": "@io.jesi/parent/package-dry.json",
    "dependencies": {
      "@io.jesi/parent": "X.Y.Z"
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
