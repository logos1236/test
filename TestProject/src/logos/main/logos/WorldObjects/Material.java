package logos.main.logos.WorldObjects;
import java.util.ArrayList;

/**
 * Created by Logos on 23.05.2017.
 */
public class Material implements MaterialIntreface {
    private String name;
    private double density; /*=== Плотность ===*/
    private boolean flammability; /*=== Может ли гореть ===*/
    private int physical_condition; /*=== Газообразное - 0; Жидкое - 1; Тведрое - 2;  ===*/
    private Material[] composition; /*=== Газообразное - 0; Жидкое - 1; Тведрое - 2;  ===*/

    /*=== Элементарные ===*/
    /*=== Материалы (твердые) ===*/
    public static final Material COAL = new Material("coal", 120, false, 2, new Material[0]);
    public static final Material SOIL = new Material("soil", 1400, false, 2, new Material[0]);
    /*=== ! Материалы (твердые) ===*/

    /*=== Материалы (жидкие) ===*/
    /*=== ! Материалы (жидкие) ===*/

    /*=== Материалы (газообразные) ===*/
    public static final Material CARBONE_DIOXIDE = new Material("carbon dioxide", 2, false, 0, new Material[0]);
    public static final Material OXYGEN = new Material("oxygen", 1.4, true, 0, new Material[0]);
    public static final Material HELIUM = new Material("heliuum", 0.2, false, 0, new Material[0]);
    /*=== ! Материалы (газообразные) ===*/

    /*=== Составные ===*/
    /*=== Материалы (твердые) ===*/
    public static final Material WOOD = new Material("wood", 450, true, 2, new Material[0]);
    /*=== !Материалы (твердые) ===*/

    /*=== Материалы (жидкие) ===*/
    public static final Material WATER = new Material("water", 1000, false, 1, new Material[]{OXYGEN, HELIUM});
    /*=== ! Материалы (жидкие) ===*/

    /*=== Материалы (газообразные) ===*/
    /*=== ! Материалы (газообразные) ===*/

    private void setName(String name) {
        this.name = name;
    }
    private void setDensity(double density) {
        this.density = density;
    }
    private void setFlammability(boolean flammability) {
        this.flammability = flammability;
    }
    private void setPhysicalCondition(int physical_condition) {
        this.physical_condition = physical_condition;
    }
    private void setComposition(Material[] composition) { this.composition = composition; }
    private Material[] getComposition() { return this.composition; }

    public String getName() {
        return this.name;
    }

    public int getPhysicalCondition() {
        return this.physical_condition;
    }
    public boolean isSolid() {
        boolean result;
        if (this.getPhysicalCondition() == 2) {
            result = true;
        } else {
            result = false;
        }

        return result;
    }

    private Material (String name, double density, boolean flammability, int physical_condition, Material[] composition) {
        this.setName(name);
        this.setDensity(density);
        this.setFlammability(flammability);
        this.setPhysicalCondition(physical_condition);
        this.setComposition(composition);
    }

    /*=== Сжигаем материал ===*/
    @Override
    public ArrayList<Material> BurnMaterial() {
        ArrayList<Material> return_list = new ArrayList<Material>();

        /*=== Дерево ===*/
        if (this == WOOD) {
            return_list.add(COAL);
            return_list.add(CARBONE_DIOXIDE);
        }

        return return_list;
    }

    /*=== Разагаем материал ===*/
    @Override
    public Material[] DecomposeMaterial() {
        return this.getComposition();
    }
}

