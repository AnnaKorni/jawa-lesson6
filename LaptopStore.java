package v2.homework6;

import java.util.*;

public class LaptopStore {
    public static void main(String[] args) {
        Set<Laptop> laptops = new HashSet<>();
        laptops.add(new Laptop(32, "Windows 10"));
        laptops.add(new Laptop(16, "Mac OS"));
        laptops.add(new Laptop(8, "Linux"));
        Map<Integer, String> criteria = new HashMap<>();
        criteria.put(1, "ОЗУ");
        criteria.put(2, "Операционная система");
        Scanner scanner = new Scanner(System.in);
        Map<String, Object> filters = new HashMap<>();
        boolean continueFiltering = true;
        while (continueFiltering) {
            System.out.println("Введите цифру, соответствующую необходимому критерию:");
                for (Map.Entry<Integer, String> entry : criteria.entrySet()) {
                    System.out.println(entry.getKey() + " - " + entry.getValue());
                }
                int criterion = scanner.nextInt();
                scanner.nextLine(); // Очистка буфера от символа новой строки
                switch (criterion) {
                    case 1:
                        System.out.print("Введите минимальное значение ОЗУ (в ГБ): ");
                        filters.put("ram", scanner.nextInt());
                        scanner.nextLine(); // Очистка буфера от символа новой строки
                        break;

                    case 2:
                        System.out.print("Введите операционную систему: ");
                                filters.put("os", scanner.nextLine());
                        break;
                }
                System.out.print("Хотите добавить еще один критерий? (да/нет): ");
                String response = scanner.nextLine();
                continueFiltering = response.equalsIgnoreCase("да");
            }
            filterLaptops(laptops, filters);
        }
        public static void filterLaptops(Set<Laptop> laptops, Map<String, Object> filters) {
            for (Laptop laptop : laptops) {
                boolean matches = true;
                if (filters.containsKey("ram") && laptop.getRam() <
                        (int) filters.get("ram")) {
                    matches = false;
                }

                if (filters.containsKey("os") &&
                        !laptop.getOs().equalsIgnoreCase((String) filters.get("os"))) {
                    matches = false;
                }
                if (matches) {
                    System.out.println(laptop);
                }
            }
        }
    }

