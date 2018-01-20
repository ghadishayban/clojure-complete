(ns complete.core-test
  (:use complete.core clojure.test))

(deftest completions-test
  (is (= '("alength" "alias" "all-ns" "alter" "alter-meta!" "alter-var-root")
         (completions "al" 'clojure.core)))

  (is (= '("jio/make-input-stream" "jio/make-output-stream" "jio/make-parents" "jio/make-reader" "jio/make-writer")
         (completions "jio/make" 'clojure.core)))

  (is (= '("clojure.core/alter" "clojure.core/alter-meta!" "clojure.core/alter-var-root")
         (completions "clojure.core/alt" 'clojure.core)))

  (is (= '("clojure.core" "clojure.core.ArrayChunk" "clojure.core.ArrayManager" "clojure.core.IVecImpl" "clojure.core.Vec" "clojure.core.VecNode" "clojure.core.VecSeq" "clojure.core.protocols" "clojure.core.protocols.InternalReduce")
         (completions "clojure.co")))

  (is (= '("complete.core" "complete.core-test")
         (completions "complete.core")))

  (is (= '("System/out")
         (completions "System/o")))

  (is (= '("java.lang.System/out")
         (completions "java.lang.System/out")))

  (is (= () (completions "fake-ns-here/")))

  (is (= () (completions "/")))

  (is (some #{"String/valueOf"} (completions "String/")))

  (is (not (some #{"String/indexOf" ".indexOf"} (completions "String/")))))
