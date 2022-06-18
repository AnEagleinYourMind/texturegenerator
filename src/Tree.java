import java.awt.*;

public class Tree extends TextureGroup {
    private final Color bark, leaves, wood;
    private final String type;

    public Tree(String typeName, String path, String treeType, Color barkColor, Color leavesColor, Color woodColor) {
        type = treeType;
        this.typeName = typeName;
        this.path = path;
        bark = barkColor;
        leaves = leavesColor;
        wood = woodColor;
    }

    public void generateTextures() {
        switch (type) {
            case "decd":
                TwoLayeredTemplateImage deciduousSapling = new TwoLayeredTemplateImage(
                        "deciduous_sapling_bottom.png",
                        "deciduous_sapling_top.png", bark, leaves);
                deciduousSapling.combine();
                deciduousSapling.save(path, typeName + "_sapling");
                break;
            case "conf":
                TwoLayeredTemplateImage coniferousSapling = new TwoLayeredTemplateImage(
                        "coniferous_sapling_bottom.png",
                        "coniferous_sapling_top.png", bark, leaves);
                coniferousSapling.combine();
                coniferousSapling.save(path, typeName + "_sapling");
                break;
            case "conf_alt":
                TwoLayeredTemplateImage altConiferousSapling = new TwoLayeredTemplateImage(
                        "coniferous_sapling_bottom_2.png",
                        "coniferous_sapling_top_2.png", bark, leaves);
                altConiferousSapling.combine();
                altConiferousSapling.save(path, typeName + "_sapling");
                break;
        }

        TwoLayeredTemplateImage logTop = new TwoLayeredTemplateImage("log_top_template_top.png",
                "log_top_template_bottom.png", bark, wood);
        logTop.combine();
        logTop.save(path, typeName + "_log_top");

        SingleTemplateImage logSide = new SingleTemplateImage("log.png", bark);
        logSide.iterateBottomTemplate();
        logSide.save(path, typeName + "_log");

        SingleTemplateImage strippedLog = new SingleTemplateImage("stripped_log_top.png", wood);
        strippedLog.iterateBottomTemplate();
        strippedLog.save(path, "stripped_" + typeName + "_log_top");

        SingleTemplateImage strippedLogSide = new SingleTemplateImage("stripped_log.png", wood);
        strippedLogSide.iterateBottomTemplate();
        strippedLogSide.save(path, "stripped_" + typeName + "_log");

        SingleTemplateImage planks = new SingleTemplateImage("planks.png", wood);
        planks.iterateBottomTemplate();
        planks.save(path, typeName + "_planks");
    }
}
