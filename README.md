# EBS_HomeWork

# Evaluarea implementării paralelizării

## Tipul de paralelizare
Implementarea folosește paralelizarea pe fire de execuție (threads) pentru generarea publicațiilor și a subscripțiilor.

## Factorul de paralelism
Am testat implementarea cu două configurații:
- 1 fir de execuție (fără paralelizare)
- 4 fire de execuție

## Testele efectuate
- **Numărul de mesaje generate**: 
  - 100,000 publicații
  - 100,000 subscripții
- **Timpii obținuți**:
  - 1 fir de execuție: **1362 ms**
  - 4 fire de execuție: **660 ms**

## Specificațiile procesorului
Testele au fost efectuate pe un procesor Intel(R) Core(TM) i7-7700HQ CPU @ 2.80GHz.

## Concluzii
- Paralelizarea a avut un impact semnificativ asupra timpului de generare pentru un număr mare de publicații și subscripții.
- Performanța a fost îmbunătățită semnificativ atunci când au fost utilizate 4 fire de execuție, comparativ cu 1 fir de execuție.
