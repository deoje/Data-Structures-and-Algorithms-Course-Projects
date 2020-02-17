package tp2;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.ArrayList;

public class Interview {
    /**
     * Finds all pairs within values which sum up to targetSum
     * @param values All possible values that can form a pair (can contain duplicates)
     * @param targetSum Pairs should add up to this
     * @return A collection containing all valid pairs with no permutations, but all combinations (empty collection if none found)
     */
    public Collection<MatchingPair> matchingPairs(Collection<Integer> values, Integer targetSum){
        ArrayList<MatchingPair> collectionFinale = new ArrayList<>();

        //s'il manque une valeur alors on retourne une collection vide
        if (values.size() == 0 || targetSum == null){
            return collectionFinale;
        }

        //On parcours le tableau pour additioner chacune de ses valeurs
        for (Iterator<Integer> iterator = values.iterator(); iterator.hasNext();) {
            //la premiere valeur à additioner
            int valeur_a = iterator.next();

            //On va faire l'addition avec chacune des valeurs
            for (Iterator<Integer> iterator2 = values.iterator(); iterator2.hasNext(); ) {
                //la deuxieme valeur a additioner
                int valeur_b = iterator2.next();

                // FIXME: Trouver moyen pour si _2 et 2_ sont dans valeurs et target = 4 alors prendre la paire (_2, 2_)?
                //Si l'addtion marche
                if ((valeur_b + valeur_a == targetSum && valeur_b != valeur_a)) {
                    //ajouter la paire a la collection
                    collectionFinale.add(new MatchingPair(valeur_b, valeur_a));
                }

            }

        }
//        //Go over each pair
//        for (MatchingPair pair_a : collectionFinale) {
//            // FIRST pair of the possible couple ((a,b),(b,a))
//            // SECOND pair of the possible couple ((a,b),(b,a))
//            // si cas (a,b) et (b,a) on doit que guarder une
//            // ERREUR : le remove adapte bien iterator 3 et 4 et la collection mais ca créé une erreur pour iterator3.next()... Why?
//            collectionFinale.removeIf(pair_b -> pair_a.first == pair_b.second && pair_a.second == pair_b.first);
//        }
        int i = 0;
        while (i != collectionFinale.size() / 2 - 1){
            if (collectionFinale.size() == 0)
                break;

            MatchingPair pair_a = collectionFinale.get(i);

            if (collectionFinale.removeIf(pair_b -> pair_a.first.equals(pair_b.second) && pair_a.second.equals(pair_b.first)))
                i = 0;
            
            i++;
        }
        return collectionFinale;
    }
}

