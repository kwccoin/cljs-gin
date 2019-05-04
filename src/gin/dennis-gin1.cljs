(def game (atom {}))

(defn s [text]
  (println "cmd-" text))

(defn add-msg-watcher []
  (add-watch game :msg-watcher
             (fn [key ref old new]
               (let [state (:state new)]
                 (-> (condp = state
                         :our-pick-move "Your turn. Draw a card or pickup a discard."
                         :our-discard-move "Drag a card from your hand to discard."
                         :opponent-move "Opponent to move."
                         :pat-tie "Game over: Both dealt gin for a tie."
                         :pat-our-win "Game over: You win, dealt gin."
                         :pat-opp-win "Game over: Opponent wins, dealt gin."
                         :our-win "Game over: You win!"
                         :opp-win "Game over: Opponent wins."
                         "Ginrummy.")
                     set-msg)))))