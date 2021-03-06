(ns gin.gametest
  (:require [gin.game :as game]))

(defn run-tests []
  (assert (= (game/card->str {:rank :8 :suit :club}) "8c"))
  (assert (= (game/str->card "8c") {:rank :8 :suit :club}))
  
  (assert (= 10 (game/gin-size (map game/str->card '("3c" "3s" "3d" "8h" "8c" "8s" "Jh" "Qh" "Kh" "Ah")))))
  (assert (= 6 (game/gin-size (map game/str->card '("3c" "3s" "3d" "8h" "8c" "8s")))))
  (assert (= 0 (game/gin-size (map game/str->card ["2h" "2c" "3h"]))))
  (assert (= 3 (game/gin-size (map game/str->card '("3c" "3s" "3d")))))
  (assert (= 3 (game/gin-size (map game/str->card '("8h" "8c" "8s")))))
  (assert (= 3 (game/gin-size (map game/str->card '("2h" "3h" "4h")))))
  (assert (= 4 (game/gin-size (map game/str->card '("2h" "3h" "4h" "5h")))))
  (assert (= 4 (game/gin-size (map game/str->card '("Jh" "Qh" "Kh" "Ah")))))
  (assert (= 10 (game/gin-size (map game/str->card '("7s" "7h" "3s" "2s" "Kh" "Kc" "4s" "7d" "As" "Ks")))))
  (assert (= 7 (game/gin-size '({:rank :6, :suit :heart} {:rank :7, :suit :heart} {:rank :8, :suit :heart} {:rank :9, :suit :heart} {:rank :T, :suit :spade} {:rank :T, :suit :heart} {:rank :T, :suit :club} {:rank :A, :suit :club}))))
  (assert (= 10 (game/gin-size (map game/str->card '("Ac" "Ts" "6h" "8h" "Th" "3c" "9h" "7h" "2c" "Tc")))))
  (assert (= 4 (game/gin-size (map game/str->card ["Ac" "As" "Ad" "Ah"]))))
  (assert (= 4 (game/gin-size (map game/str->card ["3c" "3s" "3d" "3h"]))))
  (assert (= 3 (game/gin-size (map game/str->card ["Ac" "Ad" "Ah"])))) 
  (assert (= 4 (game/gin-size (map game/str->card ["Jh" "Qh" "Kh" "Ah"]))))
  (assert (= 3 (game/gin-size (map game/str->card ["Qh" "Kh" "Ah"]))))
  (assert (= 4 (game/gin-size (map game/str->card ["2h" "4h" "3h" "Ah"]))))
  (assert (= 3 (game/gin-size (map game/str->card ["2h" "3h" "Ah"]))))
  (assert (= 7 (game/gin-size (map game/str->card ["Jh" "Qh" "Js" "Jd" "Kh" "Jc" "Ah"]))))
  (assert (= 6 (game/gin-size (map game/str->card ["Jh" "Qh" "Js" "Jd" "Kh" "Jc" "Ad"]))))
  (assert (= 7 (game/gin-size (map game/str->card ["2h" "4h" "3h" "Ah" "Ac" "Qc" "Kc"]))))
  (assert (= 7 (game/gin-size (map game/str->card ["2h" "4h" "3h" "Ah" "Ac" "As" "Ad"]))))
  (assert (= 0 (game/gin-size (map game/str->card ["Jh" "Qh" "Ah" "Jc" "Qc" "Ac"]))))
  (assert (= 0 (game/gin-size (map game/str->card ["Jh" "Qh" "Jc" "Qc"]))))
  (assert (= 0 (game/gin-size (map game/str->card ["Jh" "Qh" "Jc"]))))
  (assert (= 0 (game/gin-size (map game/str->card ["Kh" "Ah"]))))
  (assert (= 6 (game/gin-size (map game/str->card ["3d" "3s" "3c" "3h" "4d" "4s" "5s"]))))
  (assert (= 10 (game/gin-size (map game/str->card ["2h" "2c" "2s" "2d" "8h" "8s" "8d" "Js" "Jd" "Jh"]))))
  (assert (= 10 (game/gin-size (map game/str->card ["9h" "9c" "9d" "9s" "Th" "Td" "Ts" "Tc" "Jc" "Qc"]))))
  (assert (= 10 (game/gin-size (map game/str->card ["3h" "4h" "5h" "3c" "3d" "3s" "Ts" "Tc" "Td" "Th"]))))
  (assert (= 7 (game/gin-size (map game/str->card ["4h" "5h" "6h" "4c" "6c" "4d" "8s" "9s" "Ts" "Js"]))))
  (assert (= 6 (game/gin-size (map game/str->card ["4h" "5h" "6h" "4c" "6c" "8c" "4d" "8s" "9s" "Ts" ]))))
  


  (assert (= (game/choosediscard (map game/str->card ["5s" "6s" "7d" "9h" "9c" "Qh" "Qc" "Qd" "Ah" "As" "Qs"]) #{}) {:rank :7 :suit :diamond}))
  (assert (= (game/choosediscard (map game/str->card ["2h" "3h" "4h" "5h" "Ah" "5c" "3s" "5s" "6s" "7s" "8s"]) #{}) {:rank :3 :suit :spade}))
  (assert (= 10 (game/gin-size (map game/str->card ["2h" "3h" "4h" "5h" "Ah" "5c" "5s" "6s" "7s" "8s"]))))
  (assert (= 4 (game/gin-size (map game/str->card ["2h" "3h" "4h" "5h"]))))
  (assert (= 7 (game/gin-size (map game/str->card ["3h" "3c" "3d" "3s" "5d" "8c" "8d" "8s" "Ac" "As"]))))
  (assert (= 4 (game/gin-size (map game/str->card ["3h" "3c" "3d" "3s"]))))
  (assert (= 3 (game/gin-size (map game/str->card ["8c" "8d" "8s"]))))
  (assert (= (game/pair-rating (map game/str->card ["5s" "7d" "9h" "9c" "Qh" "Qc" "Qd" "Ah" "As" "Qs"]) #{}) 56))
  (assert (= (game/pair-rating (map game/str->card ["5s" "6s"  "9h" "9c" "Qh" "Qc" "Qd" "Ah" "As" "Qs"]) #{}) 60))
  
  
)
;;(run-tests)
