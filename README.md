Gestion compte bancaire
=======================

## Le contexte de l'exercice
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
1. Un dépôt de 1000 le 25-05-2022 et 2000 le 26-05-2022 <br />
2. Un retrait de 500 le 27-05-2022 <br />
3. Quand il imprime son relevé bancaire le résultat est :<br />

   Operation | Date        | Montant   | Solde <br />
   RETRAIT   | 27/05/2022  | 500.00    | 2500.00 <br />
   VERSER    | 26/05/2022  | 2000.00   | 3000.00 <br />
   VERSER    | 25/05/2022  | 1000.00   | 1000.00 <br />


