package Controller;

import Database.List;
import Model.Burger;

public class ShopController {

    List list = new List();

    public int size() {
        return list.listSize();
    }

    // generate order Id
    public String generateOrderId() {
        if (list.listSize() == 0) {
            return "B0001";
        }
        String lastOrderId = list.get(list.listSize() - 1).getOrderId();
        int number = Integer.parseInt(lastOrderId.split("B")[1]); // 1
        number++;// 2
        return String.format("B%04d", number); // printf("",) //B0002
    }

    public boolean isExitCustomer(String customerId) {
        for (int i = 0; i < list.listSize(); i++) {
            if (customerId.equals(list.get(i).getCustomerId())) {
                return true;
            }
        }
        return false;
    }

    public boolean isExitOrder(String orderId) {
        for (int i = 0; i < list.listSize(); i++) {
            if (orderId.equals(list.get(i).getOrderId())) {
                return orderId.equals(list.get(i).getOrderId());
            }
        }
        return false;
    }

    public String getCustomerId(String orderId) {
        for (int i = 0; i < list.listSize(); i++) {
            if (orderId.equals(list.get(i).getOrderId())) {
                return list.get(i).getCustomerId();
            }
        }
        return null;
    }

    public String getCustomer(String orderId) {
        for (int i = 0; i < list.listSize(); i++) {
            if (orderId.equals(list.get(i).getOrderId())) {
                return list.get(i).getCustomerName();
            }
        }
        return null;
    }

    public int getOrderQTY(String orderId) {
        for (int i = 0; i < list.listSize(); i++) {
            if (orderId.equals(list.get(i).getOrderId())) {
                return list.get(i).getOrderQTY();
            }
        }
        return -1;
    }

    public double getOrderValue(String orderId) {
        for (int i = 0; i < list.listSize(); i++) {
            if (orderId.equals(list.get(i).getOrderId())) {
                return list.get(i).getOrderValue();
            }
        }
        return 0.0;
    }

    public Burger getOrder(String orderId) {
        for (int i = 0; i < list.listSize(); i++) {
            if (orderId.equals(list.get(i).getOrderId())) {
                return list.get(i);
            }
        }
        return null;
    }

    public String getOrderStatus(String orderId) {
        for (int i = 0; i < list.listSize(); i++) {
            if (orderId.equals(list.get(i).getOrderId())) {
                switch (list.get(i).getOrderStatus()) {
                    case Burger.CANCEL:
                        return "Cancel";
                    case Burger.PREPARING:
                        return "Preparing";
                    case Burger.DELIVERED:
                        return "Delivered";
                }
            }
        }
        return null;
    }

    public String getCustomerName(String customerId) {
        for (int i = 0; i < list.listSize(); i++) {
            if (list.get(i).getCustomerId().equals(customerId)) {
                return list.get(i).getCustomerName();
            }
        }
        return null;
    }

    public String getCustomerName(Burger obj) {
        return obj.getCustomerName();
    }

    public String getCustomerId(Burger obj) {
        return obj.getCustomerId();
    }

    public String getOrderId(Burger obj) {
        return obj.getOrderId();
    }

    public double getOrderValue(Burger obj) {
        return obj.getOrderValue();
    }

    public int getOrderQTY(Burger obj) {
        return obj.getOrderQTY();
    }

    public void addOrder(String orderId, String customerName, String customerId, int qty, double billValue) {
        Burger obj = new Burger();
        obj.setOrderId(orderId);
        obj.setCustomerName(customerName);
        obj.setOrderStatus(1);
        obj.setCustomerId(customerId);
        obj.setOrderQTY(qty);
        obj.setOrderValue(billValue);

        list.add((list.listSize()), obj);
        obj = null;
    }

    public Burger[] sort() {
        Burger[] sortBurgerArray = new Burger[0];

        for (int i = 0; i < list.listSize(); i++) {
            boolean isExist = false;
            for (int j = 0; j < sortBurgerArray.length; j++) {
                if (sortBurgerArray[j].getCustomerId().equals(list.get(i).getCustomerId())) {
                    if (list.get(i).getOrderStatus() != Burger.CANCEL) {
                        sortBurgerArray[j]
                                .setOrderValue(sortBurgerArray[j].getOrderValue() + list.get(i).getOrderValue());
                    }
                    isExist = true;
                }
            }
            if (!isExist && (list.get(i).getOrderStatus() != Burger.CANCEL)) {
                Burger[] tempSortBurgerArray = new Burger[sortBurgerArray.length + 1];
                for (int j = 0; j < sortBurgerArray.length; j++) {
                    Burger tempObj = new Burger();

                    tempObj.setOrderId(sortBurgerArray[j].getOrderId());
                    tempObj.setCustomerId(sortBurgerArray[j].getCustomerId());
                    tempObj.setCustomerName(sortBurgerArray[j].getCustomerName());
                    tempObj.setOrderQTY(sortBurgerArray[j].getOrderQTY());
                    tempObj.setOrderStatus(sortBurgerArray[j].getOrderStatus());
                    tempObj.setOrderValue(sortBurgerArray[j].getOrderValue());

                    tempSortBurgerArray[j] = tempObj;
                    tempObj = null;
                }
                sortBurgerArray = tempSortBurgerArray;

                Burger lastObj = new Burger();

                lastObj.setOrderId(list.get(i).getOrderId());
                lastObj.setCustomerId(list.get(i).getCustomerId());
                lastObj.setCustomerName(list.get(i).getCustomerName());
                lastObj.setOrderQTY(list.get(i).getOrderQTY());
                lastObj.setOrderStatus(list.get(i).getOrderStatus());
                lastObj.setOrderValue(list.get(i).getOrderValue());

                sortBurgerArray[sortBurgerArray.length - 1] = lastObj;
                lastObj = null;
            }
        }

        // sort
        for (int i = 1; i < sortBurgerArray.length; i++) {
            for (int j = 0; j < i; j++) {
                if (sortBurgerArray[j].getOrderValue() < sortBurgerArray[i].getOrderValue()) {
                    Burger temp = sortBurgerArray[j];
                    sortBurgerArray[j] = sortBurgerArray[i];
                    sortBurgerArray[i] = temp;
                }
            }
        }
        return sortBurgerArray;
    }

    public Burger[] searchCustomer(String customerId) {
        int count = 0;
        for (int i = 0; i < list.listSize(); i++) {
            if (list.get(i).getCustomerId().equals(customerId)) {
                count++;
            }
        }
        Burger[] array = new Burger[count];
        int index = 0;
        for (int j = 0; j < list.listSize(); j++) {
            if (list.get(j).getCustomerId().equals(customerId)) {
                array[index] = list.get(j);
                index++;
            }
        }
        return array;
    }

    public Burger[] viewOreders(int status) {
        int count = 0;
        for (int i = 0; i < list.listSize(); i++) {
            if (list.get(i).getOrderStatus() == status) {
                count++;
            }
        }
        Burger[] deliveredOrderArray = new Burger[count];
        int index = 0;
        for (int i = 0; i < list.listSize(); i++) {
            if (list.get(i).getOrderStatus() == status) {
                deliveredOrderArray[index++] = list.get(i);
            }
        }
        return deliveredOrderArray;
    }

    public void updateQTY(String orderId, int QTY) {
        Burger obj = getOrder(orderId);
        obj.setOrderQTY(QTY);
        obj.setOrderValue(QTY * Burger.BURGERPRICE);
    }

    public void updateStatus(String orderId, int status) {
        Burger obj = getOrder(orderId);
        obj.setOrderStatus(status);
    }
}
