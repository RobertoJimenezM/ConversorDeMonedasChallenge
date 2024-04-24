public class Divisa {

    private String base_code;
    private String target_code;
    private double conversion_result;


    public Divisa(DivisaRecord divisaRecord) {
        this.base_code = divisaRecord.base_code();
        this.target_code = divisaRecord.target_code();
        this.conversion_result = divisaRecord.conversion_result();
    }

    @Override
    public String toString() {
        return  "" + conversion_result;

    }
}
