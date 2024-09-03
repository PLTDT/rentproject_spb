package linepay.test.linepay.vo;

public class PaymentResponse {
    private String webLink;
    private String transactionId;

    // Constructors
    public PaymentResponse(String webLink, String transactionId) {
        this.webLink = webLink;
        this.transactionId = transactionId;
    }

    // Getters and setters
    public String getWebLink() {
        return webLink;
    }

    public void setWebLink(String webLink) {
        this.webLink = webLink;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }
}
