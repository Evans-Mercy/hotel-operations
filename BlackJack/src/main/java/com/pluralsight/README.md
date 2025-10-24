# BLACKJACK GAME
## STRUCTURE

### Classes
        - Main (entry point starts the game and handles input)
        - Card (represents a single playing card)
        - Deck (Holds all cards, can shuffle and deal cards)
        - Hand (Represents a player's hand)
        - Player (to store name & hand separately)

### Main:
- asks how many players are playing
- asks for each players name
- creates and shuffles a deck
- deals 2 cards to each player
- displays all player hands and scores
- determine who's closest to 21 without going over

### Card:
- suit
- value
- isFaceUp

### Deck:
- holds all 52 cards
- need to shuffle cards 
- deal cards (2 cards to each hand)

### Hand:
- holds the cards a player currently has
- calculates the total value of the hand
- handles the Ace rule

### Player:
- represents an individual player
- stores the players name and their hand
- helps identify each player during the game

## Game flow
1. Set up
    - Prompt the user for the number of players
    - Create a deck and shuffle it
    - Create a player object for each participant

2. Initial deal
    - Deal 2 cards to each player's hand
    - Display each hand and its total

4. Determine winner
    - If player's total is closest to 21 without going over

## Unit Testing
