package net.brianjlee.springExample;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class PhoneNumber {
    @Column(name = "phone_number")
    private String number;

    public void setNumber(String number) throws IllegalArgumentException {
        if (number.length() == 12) this.number = number;
        else if (number.length() == 10) {
            String area = number.substring(0, 3);
            String exchange = number.substring(3, 6);
            String num = number.substring(6, 10);
            this.number = String.format("%s-%s-%s", area, exchange, num);
        } else {
            throw new IllegalArgumentException("Phone numbers should be submitted either as 10-digit string without punctuations or 12-digit string in 3-3-4 format");
        }
    }

    public String getNumber() {
        return this.number;
    }

    public String getFormattedNumber() {
        String area = number.substring(0, 3);
        String exchange = number.substring(4, 7);
        String num = number.substring(8, 12);
        return String.format("(%s) %s-%s", area, exchange, num);
    }

    public String getShortNumber() {
        String area = number.substring(0, 3);
        String exchange = number.substring(4, 7);
        String num = number.substring(8, 12);
        return area + exchange + num;
    }
}
