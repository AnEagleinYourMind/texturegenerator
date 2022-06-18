import java.awt.Color;

public class Main {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.err.println("Required arguments: type, name, r, g, b, [r, g, b, r, g, b], path");
        } else if (args.length >= 5) {
            String blockType = args[0];
            String blockName = args[1];

            switch(blockType) {
                case "stone":
                    Color blockColor = new Color(Integer.parseInt(args[2]), Integer.parseInt(args[3]), Integer.parseInt(args[4]));
                    Stone stoneTexture = new Stone(blockName, args[5], blockColor);
                    stoneTexture.generateTextures();
                    stoneTexture.createColorInfo(new Color[] {blockColor});
                    break;
                case "tree":
                    System.out.println("Block to generate: tree");
                    try {
                        Color barkColor = new Color(Integer.parseInt(args[3]), Integer.parseInt(args[4]), Integer.parseInt(args[5]));
                        Color leavesColor = new Color(Integer.parseInt(args[6]), Integer.parseInt(args[7]), Integer.parseInt(args[8]));
                        Color woodColor = new Color(Integer.parseInt(args[9]), Integer.parseInt(args[10]), Integer.parseInt(args[11]));
                        // bruh

                        Tree treeTextures = new Tree(blockName, args[12], args[2], barkColor, leavesColor, woodColor);
                        treeTextures.generateTextures();
                        treeTextures.createColorInfo(new Color[] {barkColor, leavesColor, woodColor});
                    } catch (IllegalArgumentException e) {
                        System.err.println(e.getLocalizedMessage() + " (maximum value is 255)");
                    }
                    break;
                default:
                    System.err.println("No generator type specified");
                    break;
            }
        }

        /*
        sycamore, white elm, american beech
        limestone, chert, black shale, basalt, rhyolite, sandstone,
        red granite, black granite, serpentinite, phonolite, blue-schist,
        green-schist, syenite, gneiss, slate, komatiite, ironstone,
        red marble, white marble

        Tree whitePine = new Tree("white_pine", path, 1, new Color(43, 37, 33), new Color(51, 75, 0), new Color(204, 151, 102));
        Tree redPine = new Tree("red_pine", path, 1, new Color(72, 58, 52), new Color(51, 75, 0), new Color(201, 152, 117));
        Tree ponderosaPine = new Tree("ponderosa_pine", path, 1, new Color(72, 58, 52), new Color(116, 140, 73), new Color(206, 161, 136));
        Tree redCedar = new Tree("red_cedar", path, 2, new Color(57, 33, 36), new Color(85, 107, 36), new Color(186, 129, 78));
        Tree whiteCedar = new Tree("white_cedar", path, 2, new Color(128, 120, 120), new Color(76, 94, 43), new Color(152, 117, 84));
        Tree osageOrange = new Tree("osage_orange", path, 0, new Color(101, 72, 54), new Color(104, 126, 78), new Color(173, 113, 58));
        */
    }
}
