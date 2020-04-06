(defproject io.jesi/parent "3.6.0"
  :description "Clojure and NPM parent package definitions"
  :url "https://github.com/jesims/parent#readme"
  :license {:name         "Eclipse Public License - v 1.0"
            :url          "http://www.eclipse.org/legal/epl-v10.html"
            :distribution :repo
            :comments     "same as Clojure"}
  :min-lein-version "2.9.1"
  :managed-dependencies [[org.clojure/clojure "1.10.1"]
                         [thheller/shadow-cljs "2.8.83"]
                         [org.clojure/clojurescript "1.10.597"] ;Match version used in shadow-cljs
                         [io.jesi/backpack "5.1.0"]
                         [io.jesi/customs "1.0.0"]
                         [com.rpl/specter "1.1.3"]
                         [org.clojure/core.async "0.7.559"]
                         ;DB
                         [org.clojure/java.jdbc "0.7.11"]
                         [org.postgresql/postgresql "42.2.10"]
                         [clj-postgresql "0.7.0"]
                         [nilenso/honeysql-postgres "0.2.6"]]
  :dependencies [[org.clojure/clojure]]
  :plugins [[lein-pprint "1.3.2"]]
  :profiles {:parent/dev {:plugins      [[jonase/eastwood "0.3.7"]
                                         [lein-ancient "0.6.15"]
                                         [lein-auto "0.1.3"]
                                         [lein-codox "0.10.7"]
                                         [lein-kibit "0.1.8"]
                                         [lein-nsorg "0.3.0"]
                                         [lein-set-version "0.4.1"]]
                          :eastwood     {:exclude-linters [:local-shadows-var]}
                          ;TODO split CLJ and CLJS dependencies to separate profiles
                          :dependencies [[clj-kondo "RELEASE"]
                                         [lambdaisland/kaocha "0.0-590"]
                                         [thheller/shadow-cljs]
                                         [org.clojure/clojurescript]
                                         [lambdaisland/kaocha-cljs "0.0-68"]]}}
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
