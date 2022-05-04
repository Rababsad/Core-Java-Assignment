class Account {
  static int balance = 1000;
  static int balance1 = 1000;
  String jointAcc_HolderName1 = "Rabab";
  String jointAcc_HolderName2 = "Priya";

  void withdraw1(int amount) {
    if (balance >= amount) {
      System.out.println("withdraw amount successfully");
      balance = balance - amount;
      System.out.println("Remaining amount after Withdrawal for unsafe thread:" + balance);
    } else {
      System.out.println("Amount can not be Withdrawn");
    }
  }

  synchronized void withdraw2(int amount) {
    if (balance1 >= amount) {
      System.out.println("withdraw amount successfully");
      balance1 = balance1 - amount;
      System.out.println("Remaining amount after Withdrawal for safe thread:" + balance1);
    } else {
      System.out.println("Amount can not be Withdrawn");
    }
  }
}

class AccountOverDrawDemo extends Thread {
  Account b = new Account();
  int amount;

  public void run() {
    b.withdraw1(amount);
  }
}

class AccountOverDrawSafeDemo extends Thread {
  static Account b;
  int amount;

  public void run() {
    b.withdraw2(amount);
  }

  public static void main(String[] args) {
    b = new Account();

    AccountOverDrawSafeDemo t3 = new AccountOverDrawSafeDemo();
    t3.amount = 700;
    t3.start();
    AccountOverDrawSafeDemo t4 = new AccountOverDrawSafeDemo();
    t4.amount = 600;
    t4.start();
    AccountOverDrawDemo t1 = new AccountOverDrawDemo();
    t1.amount = 600;
    t1.start();
    AccountOverDrawDemo t2 = new AccountOverDrawDemo();
    t2.amount = 500;
    t2.start();
  }
}