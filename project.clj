(defproject io.jesi/parent "4.21.0"
  :description "Clojure and NPM parent package definitions"
  :url "https://github.com/jesims/parent#readme"
  :license {:name         "Eclipse Public License - v 1.0"
            :url          "http://www.eclipse.org/legal/epl-v10.html"
            :distribution :repo
            :comments     "same as Clojure"}
  :min-lein-version "2.9.1"
  :managed-dependencies [[org.clojure/clojure "1.10.3"]
                         [thheller/shadow-cljs "2.14.6"]
                         [io.jesi/backpack "7.5.0"]
                         [io.jesi/customs "1.3.3"]
                         [com.rpl/specter "1.1.3"]
                         [org.clojure/core.async "1.3.618"]
                         ;DB
                         [org.clojure/java.jdbc "0.7.12"]
                         [org.postgresql/postgresql "42.2.10"] ;TODO update to latest (42.2.12)
                         [clj-postgresql "0.7.0"]
                         [nilenso/honeysql-postgres "0.4.112"]
                         ;Match versions used in shadow-cljs https://github.com/thheller/shadow-cljs/blob/master/project.clj
                         [org.clojure/clojurescript "1.10.866"]
                         [com.google.javascript/closure-compiler-unshaded "v20210505"]
                         [org.clojure/google-closure-library "0.0-20201211-3e6c510d"]
                         [org.clojure/google-closure-library-third-party "0.0-20201211-3e6c510d"]
                         ;Fixes CLJS compiler issues
                         [com.google.guava/guava "30.1.1-jre"]]
  :dependencies [[org.clojure/clojure :scope "provided"]]
  :plugins [[lein-pprint "1.3.2"]
            [lein-ancient "0.7.0"]]
  :profiles {:parent/dev     {:plugins      [[jonase/eastwood "0.9.9"]
                                             [lein-auto "0.1.3"]
                                             [lein-codox "0.10.7"]
                                             [lein-kibit "0.1.8"]
                                             [lein-nsorg "0.3.0"]
                                             [lein-set-version "0.4.1"]]
                              :eastwood     {:exclude-linters [:local-shadows-var]}
                              ;TODO split CLJ and CLJS dependencies to separate profiles
                              :dependencies [[clj-kondo "RELEASE"]
                                             [lambdaisland/kaocha "1.0.902"]
                                             [thheller/shadow-cljs]
                                             [com.lambdaisland/glogi "1.0.136"]
                                             [com.lambdaisland/kaocha-cljs "1.0.113"]]}
             :parent/uberjar {:global-vars {*assert* false}}
             :check          {:source-paths ["src" "test"]}}
  :global-vars {*warn-on-reflection* true}
  :deploy-repositories [["clojars" {:url           "https://clojars.org/repo"
                                    :username      :env/clojars_username
                                    :password      :env/clojars_password
                                    :sign-releases false}]]
  :codox {:output-path "docs"}
  :aliases {"run-main"        ["trampoline" "run" "-m"]
            "clj-kondo"       ["run-main" "clj-kondo.main"]
            "kaocha"          ["run-main" "kaocha.runner"]
            "shadow-cljs"     ["run-main" "shadow.cljs.devtools.cli"]
            "lint-nsorg"      ["nsorg" "--replace"]
            "lint-kondo"      ["clj-kondo" "--" "--cache" "--lint" "src"] ;TODO use :project/source-paths
            "lint-test-kondo" ["clj-kondo" "--" "--cache" "--lint" "test"] ;TODO use :project/test-paths
            "lint"            ["do"
                               ["lint-nsorg"]
                               ["check"]
                               ["lint-kondo"]
                               ["lint-test-kondo"]]
            "test"            ["kaocha"]
            "tests"           ["kaocha" "--focus"]
            "test-refresh"    ["kaocha" "--watch"]
            "docs"            ["codox"]
            "check-all"       ["with-profile" "dev,check" "check"]})
