package bai82;

public class PayrollCalculator {

    private static final double SOCIAL_INSURANCE_RATE = 0.08;
    private static final double HEALTH_INSURANCE_RATE = 0.015;

    private static final double PERSONAL_DEDUCTION = 11000000;

    private static final double TAX_BRACKET_1_LIMIT = 5000000;
    private static final double TAX_BRACKET_2_LIMIT = 10000000;

    private static final double TAX_RATE_BRACKET_1 = 0.05;
    private static final double TAX_RATE_BRACKET_2 = 0.10;

    private static final double BASE_TAX_BRACKET_2 = 250000;
    private static final double BASE_TAX_BRACKET_3 = 750000;


    public void printPayroll(String name, double baseSalary, int workDays, int totalDays, double taxRate, double bonus) {
        double actualSalary = calculateActualSalary(baseSalary, workDays, totalDays);
        double insurance = calculateInsurance(actualSalary);
        double tax = calculateTax(actualSalary, insurance, taxRate);
        double netSalary = calculateNetSalary(actualSalary, insurance, tax, bonus);

        printReceipt(name, baseSalary, workDays, totalDays, actualSalary, insurance, tax, bonus, netSalary);
    }

    private double calculateActualSalary(double baseSalary, int workDays, int totalDays) {
        return baseSalary * workDays / totalDays;
    }

    private double calculateInsurance(double actualSalary) {
        double socialInsurance = actualSalary * SOCIAL_INSURANCE_RATE;
        double healthInsurance = actualSalary * HEALTH_INSURANCE_RATE;

        return socialInsurance + healthInsurance;
    }

    private double calculateTax(double actualSalary, double insurance, double taxRate) {
        double taxableIncome = actualSalary - insurance - PERSONAL_DEDUCTION;

        if (taxableIncome <= 0) {
            return 0;
        }

        if (taxableIncome <= TAX_BRACKET_1_LIMIT) {
            return taxableIncome * TAX_RATE_BRACKET_1;
        } else if (taxableIncome <= TAX_BRACKET_2_LIMIT) {
            return BASE_TAX_BRACKET_2 + (taxableIncome - TAX_BRACKET_1_LIMIT) * TAX_RATE_BRACKET_2;
        } else {
            return BASE_TAX_BRACKET_3 + (taxableIncome - TAX_BRACKET_2_LIMIT) * taxRate;
        }
    }

    private double calculateNetSalary(double actualSalary, double insurance, double tax, double bonus) {
        return actualSalary - insurance - tax + bonus;
    }

    private void printReceipt(String name, double baseSalary, int workDays, int totalDays,
                              double actualSalary, double insurance, double tax, double bonus, double netSalary) {
        System.out.println("=== BẢNG LƯƠNG SAU REFACTOR ===");
        System.out.println("Nhân viên: " + name);
        System.out.println("Lương cơ bản: " + baseSalary);
        System.out.println("Ngày công: " + workDays + "/" + totalDays);
        System.out.println("Lương thực tế: " + actualSalary);
        System.out.println("Bảo hiểm: " + insurance);
        System.out.println("Thuế TNCN: " + tax);
        System.out.println("Thưởng: " + bonus);
        System.out.println("Thực nhận: " + netSalary);
        System.out.println("-----------------------------------\n");
    }


    // CODE CŨ
//    public void printPayroll_Before(String name, double baseSalary, int workDays, int totalDays, double taxRate, double bonus) {
//        System.out.println("=== BẢNG LƯƠNG TRƯỚC REFACTOR ===");
//        System.out.println("Nhân viên: " + name);
//
//        double actualSalary = baseSalary * workDays / totalDays;
//        double insurance = actualSalary * 0.08 + actualSalary * 0.015;
//
//        double taxableIncome = actualSalary - insurance - 11000000;
//        double tax = 0;
//        if (taxableIncome > 0) {
//            if (taxableIncome <= 5000000) tax = taxableIncome * 0.05;
//            else if (taxableIncome <= 10000000) tax = 250000 + (taxableIncome - 5000000) * 0.10;
//            else tax = 750000 + (taxableIncome - 10000000) * taxRate;
//        }
//
//        double netSalary = actualSalary - insurance - tax + bonus;
//
//        System.out.println("Lương cơ bản: " + baseSalary);
//        System.out.println("Ngày công: " + workDays + "/" + totalDays);
//        System.out.println("Lương thực tế: " + actualSalary);
//        System.out.println("Bảo hiểm: " + insurance);
//        System.out.println("Thuế TNCN: " + tax);
//        System.out.println("Thưởng: " + bonus);
//        System.out.println("Thực nhận: " + netSalary);
//        System.out.println("-----------------------------------\n");
//    }



    public static void main(String[] args) {
        PayrollCalculator calculator = new PayrollCalculator();

        // Sinh dữ liệu mẫu
        String name = "Nguyen Van IT";
        double baseSalary = 30000000; // Lương 30 củ
        int workDays = 20;
        int totalDays = 22;
        double taxRate = 0.15; // Thuế bậc cao nhất áp dụng mức 15%
        double bonus = 2000000;

        // CŨ
        //calculator.printPayroll_Before(name, baseSalary, workDays, totalDays, taxRate, bonus);

        calculator.printPayroll(name, baseSalary, workDays, totalDays, taxRate, bonus);
    }
}
