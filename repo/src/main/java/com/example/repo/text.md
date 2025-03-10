# **Esercizio: Calcolo del Costo Totale di un Ordine con Sconti e Spedizione**

In questo esercizio, dovrai implementare un sistema per **calcolare il costo totale di un ordine** considerando:
1. **Il prezzo totale dei prodotti nell’ordine.**
2. **Lo sconto applicabile in base al valore dell’ordine.**
3. **Il costo della spedizione in base alla destinazione e al tipo di spedizione.**

L'obiettivo è garantire **modularità e flessibilità**, permettendo di modificare **solo** la logica dello sconto o della spedizione **senza toccare il resto del codice**.

---

## **Struttura del Progetto**
```plaintext
src/
├── main/
│ ├── java/com/example/order/
│ │ ├── DiscountService.java # Interfaccia per lo sconto
│ │ ├── StandardDiscountService.java # Implementazione base dello sconto
│ │ ├── ExpressDiscountService.java # Implementazione alternativa dello sconto
│ │ ├── ShippingService.java # Interfaccia per la spedizione
│ │ ├── StandardShippingService.java # Spedizione standard
│ │ ├── ExpressShippingService.java # Spedizione espressa
│ │ ├── OrderService.java # Servizio per il calcolo dell’ordine
│ │ ├── OrderConfig.java # Configurazione per modificare SOLO una logica
│ ├── resources/
├── test/
│ ├── java/com/example/order/
│ │ ├── OrderServiceTest.java # Test unitario
```


---

## **Obiettivi**
1. Creare un’interfaccia **DiscountService** con il metodo:
```
double applyDiscount(double orderTotal);
```
- **Se l'ordine è inferiore a 100€**, nessuno sconto.
- **Se è tra 100€ e 200€**, sconto del 5%.
- **Se è oltre 200€**, sconto del 10%.

2. Creare **due implementazioni di DiscountService**:
- **StandardDiscountService** → Sconti normali.
- **ExpressDiscountService** → Stessa logica ma con sconti leggermente più aggressivi.

3. Creare un’interfaccia **ShippingService** con il metodo:
#codelanguage
double calculateShippingCost(String country, double weight);
#/codelanguage
- Tariffe fisse per **spedizione standard** e più alte per **spedizione espressa**.

4. Creare due implementazioni di **ShippingService**:
- **StandardShippingService** → Tariffe più basse.
- **ExpressShippingService** → Tariffe più alte, basate sul peso.

5. Creare un **OrderService** che:
- Inietti entrambe le implementazioni di DiscountService e ShippingService con @Qualifier.
- Abbia il metodo:
```codelanguage
double getTotalOrderCost(double orderTotal, String discountType, String shippingType, String country, double weight);
```
- Selezioni il servizio di **sconto** e di **spedizione** corretti.
- **Lanci un’eccezione** in caso di parametri non validi.

6. Creare **OrderConfig**, che:
- **Sostituisca SOLO ExpressDiscountService con una nuova implementazione** senza toccare StandardDiscountService.

7. Creare una nuova versione di **ExpressDiscountService** con sconti migliorati.

8. Scrivere un **test unitario** per:
- Controllare il calcolo corretto del totale dell’ordine.
- Assicurarsi che la configurazione abbia sostituito solo ExpressDiscountService.

---

## **Requisiti di Calcolo**
| **Condizione** | **Sconto Standard** | **Sconto Express** |
|---------------|-----------------|-----------------|
| Ordine < 100€ | 0% | 0% |
| 100€ ≤ Ordine < 200€ | 5% | 7% |
| Ordine ≥ 200€ | 10% | 12% |

| Tipo di Spedizione | USA ("USA") | Europa ("Europe") | Altro ("Other") |
|--------------------|--------------|----------------|----------------|
| **Standard** | 10 + peso * 1.5 | 15 + peso * 2 | 20 + peso * 2.5 |
| **Express** | 25 + peso * 3 | 30 + peso * 3.5 | 40 + peso * 4 |

---