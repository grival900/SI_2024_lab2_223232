# Григориј Ваљаков 223232

## Control Flow Graph
![CFG_223232](https://github.com/grival900/SI_2024_lab2_223232/assets/138726326/b5c5e4ec-1f35-4955-a0a6-bfe941454456)

## Цикломатска комплексност
Цикломатската комплексност може да се пресмета со броење на сите одлуки во кодот + 1. Во кодот има вкупно 9 одлуки (2 јамки кои се сметаат за одлука, 7 if одлуки).
Со ова заклучуваме дека вредноста за цикломатската комплексност е 10.

## Тест случаи според Every Branch 
1. Null list test (allItems = null) - фрла RuntimeException
2. Empty list test (allItems = []) - true
3. Null name test (new Item(null, "123456", 100, 0)) - true (се поставува unknown за името)
4. Empty name test (new Item("", "123456", 100, 0)) - true (се поставува unknown)
5. Null barcode (new Item("Name", null, 100, 0)) - фрла RuntimException("No barcode")
6. Invalid barcode (new Item("Name", "12a456", 100, 0)) - RuntimeException("Invalid character in item barcode")
7. With discount (new Item("Name", "123456", 100, 0.1f)) - true (се пресметува новата сума со попуст)
8. Without discount (new Item("Name", "123456", 100, 0)) - false (сумата е оригиналната цена)
9. Special discount (new Item("Name", "012345", 350, 0.1f)) - true (од сумата се одзима дополнителниот попуст)
10. Sum less than payment test (new Item("Name", "123456", 100, 0), payment = 50) - false end

## Тест случаи според Multiple Condition
if (item.getPrice() > 300 && item.getDiscount() > 0 && item.getBarcode().charAt(0) == '0')
Тука имаме 3 подуслови (секој може да е True или False)
Вкупниот број на комбинации е 2^3 = 8
1. TTT - условот ќе биде исполнет само во овој случај (new Item("Name", "012345", 350, 0.1f))
2. TTF - Item("Name", "112345", 350, 0.1f)
3. TFT - Item("Name", "012345", 350, 0)
4. TFF - Item("Name", "112345", 350, 0)
5. FTT - Item("Name", "012345", 250, 0.1f)
6. FTF - Item("Name", "112345", 250, 0.1f)
7. FFT - Item("Name", "012345", 250, 0)
8. FFF - Item("Name", "112345", 250, 0)
