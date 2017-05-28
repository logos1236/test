package logos.main;

import logos.main.logos.WorldObjects.Brick;
import logos.main.logos.WorldObjects.Material;
import logos.main.logos.WorldObjects.WorldObjects;

import java.util.ArrayList;

/**
 * Created by Logos on 22.05.2017.
 */
public class main {
    public static void main(String[] args) {
        /*=== Create things ===*/
        ArrayList<Material> wooden_brick_material = new ArrayList<Material>();
        wooden_brick_material.add(Material.WOOD);
        Brick floor = new Brick("floor", 1, wooden_brick_material);
        /*=== ! Create things ===*/

        /*=== Burn ===*/
        /*ArrayList<WorldObjects> bonfier_result = floor.BurnObject();
        for(WorldObjects bonfier_result_obj: bonfier_result) {
            System.out.println(bonfier_result_obj.GetName());
        }*/

        /*=== Decomposite material ===*/
        Material[]  decomposite_reslt = Material.WATER.DecomposeMaterial();
        for(Material decomposite_reslt_obj: decomposite_reslt) {
            System.out.println(decomposite_reslt_obj.getName());
        }

        //System.out.println(floor.name);
        //System.out.println(floor.material.get(0).getName());
    }
}
