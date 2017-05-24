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

    /*=== Материалы (твердые) ===*/
    public static final Material WOOD = new Material("wood", 450, true, 2);
    public static final Material COAL = new Material("coal", 120, false, 2);
    /*=== ! Материалы (твердые) ===*/

    /*=== Материалы (жидкие) ===*/
    public static final Material WATER = new Material("water", 1000, false, 1);
    /*=== ! Материалы (жидкие) ===*/

    /*=== Материалы (газообразные) ===*/
    public static final Material CARBONE_DOIXIDE = new Material("carbon dioxide", 2, false, 0);
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

    private Material (String name, double density, boolean flammability, int physical_condition) {
        this.setName(name);
        this.setDensity(density);
        this.setFlammability(flammability);
        this.setPhysicalCondition(physical_condition);
    }

    @Override
    public ArrayList<Material> BurnMaterial() {
        ArrayList<Material> return_list = new ArrayList<Material>();

        if (this == WOOD) {
            return_list.add(COAL);
            return_list.add(CARBONE_DOIXIDE);
        }

        return return_list;
    }
}

