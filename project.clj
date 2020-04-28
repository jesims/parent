(defproject io.jesi/parent "3.9.0"
  :description "Clojure and NPM parent package definitions"
  :url "https://github.com/jesims/parent#readme"
  :license {:name         "Eclipse Public License - v 1.0"
            :url          "http://www.eclipse.org/legal/epl-v10.html"
            :distribution :repo
            :comments     "same as Clojure"}
  :min-lein-version "2.9.1"
  :managed-dependencies [[org.clojure/clojure "1.10.1"]
                         [thheller/shadow-cljs "2.8.109"]
                         [io.jesi/backpack "5.2.0"]
                         [io.jesi/customs "1.1.0"]
                         [com.rpl/specter "1.1.3"]
                         [org.clojure/core.async "1.1.587"]
                         ;DB
                         [org.clojure/java.jdbc "0.7.11"]
                         [org.postgresql/postgresql "42.2.10"] ;TODO update to latest (42.2.12)
                         [clj-postgresql "0.7.0"]
                         [nilenso/honeysql-postgres "0.2.6"]
                         ;Match versions used in shadow-cljs https://github.com/thheller/shadow-cljs/blob/master/project.clj
                         [org.clojure/clojurescript "1.10.741"]
                         [com.google.javascript/closure-compiler-unshaded "v20200406"]
                         [org.clojure/google-closure-library "0.0-20191016-6ae1f72f"]
                         [org.clojure/google-closure-library-third-party "0.0-20191016-6ae1f72f"]]
  :dependencies [[org.clojure/clojure :scope "provided"]]
  :plugins [[lein-pprint "1.3.2"]
            [lein-ancient "0.6.15"]]
  :profiles {:parent/dev {:plugins      [[jonase/eastwood "0.3.11"]
                                         [lein-auto "0.1.3"]
                                         [lein-codox "0.10.7"]
                                         [lein-kibit "0.1.8"]
                                         [lein-nsorg "0.3.0"]
                                         [lein-set-version "0.4.1"]]
                          :eastwood     {:exclude-linters [:local-shadows-var]}
                          ;TODO split CLJ and CLJS dependencies to separate profiles
                          :dependencies [[clj-kondo "RELEASE"]
                                         [lambdaisland/kaocha "1.0-612"]
                                         [thheller/shadow-cljs]
                                         [lambdaisland/kaocha-cljs "0.0-71"]]}}
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
            "docs"            ["codox"]})
