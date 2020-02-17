package tp2;

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
        ArrayList<MatchingPair> collectionFinale = new ArrayList<MatchingPair>();


        if (values.size() == 0 || targetSum == null){ //s'il manque une valeur alors on retourne une collection vide
            return collectionFinale;
        }

        for (Iterator<Integer> iterator = values.iterator(); iterator.hasNext();) { //On parcour le tableau pour additioner chacune de ses valeurs
            int valeur_a = iterator.next(); //la premiere valeur à additioner
            for (Iterator<Integer> iterator2 = values.iterator(); iterator2.hasNext(); ) { //On va faire l'addition avec chacune des valeurs
                int valeur_b = iterator2.next(); //la deuxieme valeur a additioner
                if ((valeur_b + valeur_a == targetSum && valeur_b != valeur_a)) { //Si l'addtion marche
                    // Doit trouver moyen pour si _2 et 2_ sont dans valeurs et target = 4 alors prendre la paire (_2, 2_)?
                    MatchingPair pair = new MatchingPair(valeur_b, valeur_a); //creer la paire
                    collectionFinale.add(pair);//ajouter la paire a la collection
                }
            }
        }

        for (Iterator<MatchingPair> iterator3 = collectionFinale.iterator(); iterator3.hasNext(); ) { //On compare toute la collection
            MatchingPair pair_a = iterator3.next(); //la paire a comparer voir si y a (a,b) et (b,a)
            for (Iterator<MatchingPair> iterator4 = collectionFinale.iterator(); iterator4.hasNext(); ) { //On compare a la paire
                MatchingPair pair_b = iterator4.next(); //l'autre paire a comparer
                if (pair_b.equals(pair_a) && pair_b != pair_a) { // si cas (a,b) et (b,a) on doit que guarder une
                    iterator4.remove(); // ERREUR : le remove adapte bien iterator 3 et 4 et la collection mais ca créé une erreur pour iterator3.next()... Why?
                }
            }
    }

        return collectionFinale;
    }
}

