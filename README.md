Gestion compte bancaire
=======================

## Context de l'exercice
------------------------
Pensez à votre expérience de compte bancaire personnel, en cas de doute, optez pour la solution la plus simple

## Besoin fonctionnel
---------------------

1. Dépôt et retrait
2. Relevé de compte
3. Impression des relevés (operation, date, amount, balance)

## Le résultat attendu de test fonctionnel
------------------------------------------
> Étant donné qu'un client effectue les operations suivantes :
1. un dépôt de 1000 le 25-05-2022 et 2000 le 26-05-2022
2. un retrait de 500 le 27-05-2022
Quand elle imprime son relevé bancaire alors elle verrait :

Operation | Date        | Montant   | Solde
RETRAIT   | 27/05/2022  | 500.00    | 2500.00
VERSER    | 26/05/2022  | 2000.00   | 3000.00
VERSER    | 25/05/2022  | 1000.00   | 1000.00


