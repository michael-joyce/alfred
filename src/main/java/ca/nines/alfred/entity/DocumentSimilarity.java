package ca.nines.alfred.entity;

public class DocumentSimilarity {

    private String reportId;

    private double similarity;

    private String type;

    public DocumentSimilarity(String reportId, double similarity, String type) {
        this.reportId = reportId;
        this.similarity = similarity;
        this.type = type;
    }

    public String getReportId() {
        return reportId;
    }

    public double getSimilarity() {
        return similarity;
    }

    public String getType() {
        return type;
    }
}