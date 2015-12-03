package edu.up.cs301.guillotine.guillotine;

import java.io.Serializable;

import edu.up.cs301.guillotine.R;

/**
 * This creates the deck of nobles.
 *
 * @author Nathan Schmedake
 * @author Muhammed Acar
 * @author Melanie Martinell
 * @author Linnea Bair
 * @version November 2015
 */
public class BuildNobleDeck implements Serializable
{
    private static final long serialVersionUID = 777L;
    protected   Noble nobleList[] = {new Noble("Tragic Figure","gray", 0, R.drawable.tragicfigure), new Noble("Hero of the People","gray", -3,R.drawable.heroofthepeople), new Noble("The Clown","gray", -2,R.drawable.theclown), new Noble("Innocent Victim","gray", -1,R.drawable.innocentvictim),
            new Noble("martyr","gray", -1,R.drawable.martyr), new Noble("martyr","gray", -1,R.drawable.martyr), new Noble("martyr","gray", -1,R.drawable.martyr), new Noble("Palace Guard","red", 0,R.drawable.palaceguard), new Noble("Palace Guard","red", 0,R.drawable.palaceguard), new Noble("Palace Guard","red", 0,R.drawable.palaceguard), new Noble("Palace Guard","red", 0,R.drawable.palaceguard), new Noble("Palace Guard","red", 0,R.drawable.palaceguard),
            new Noble("Master Spy","red", 4,R.drawable.masterspy), new Noble("general","red", 4,R.drawable.general), new Noble("colonel","red", 3,R.drawable.colonel), new Noble("Captain of the Guard","red", 2,R.drawable.captainoftheguard), new Noble("lieutenant","red", 2,R.drawable.lieutenant), new Noble("lieutenant","red", 2,R.drawable.lieutenant),
            new Noble("governor","green", 4,R.drawable.governor), new Noble("mayor","green", 3,R.drawable.mayor), new Noble("councilman","green", 3,R.drawable.councilman), new Noble("Unpopular Judge","green", 2,R.drawable.unpopularjudge), new Noble("Unpopular Judge","green", 2,R.drawable.unpopularjudge), new Noble("Tax Collector","green", 2,R.drawable.taxcollector),
            new Noble("Land lord","green", 2,R.drawable.landlord), new Noble("Rival Executioner","green", 1,R.drawable.rivalexecutioner), new Noble("sheriff","green", 1,R.drawable.sheriff), new Noble("sheriff","green", 1,R.drawable.sheriff), new Noble("cardinal","blue", 5,R.drawable.cardinal), new Noble("archbishop","blue", 4,R.drawable.archbishop), new Noble("Bad Nun","blue", 3,R.drawable.badnun),
            new Noble("bishop","blue", 2,R.drawable.bishop), new Noble("heretic","blue", 2,R.drawable.heretic), new Noble("Wealthy Priest","blue", 1,R.drawable.wealthypriest), new Noble("Wealthy Priest","blue", 1,R.drawable.wealthypriest), new Noble("King Louis XVI","purple", 5,R.drawable.kinglouisxvi), new Noble("Marie Antoinette","purple", 5,R.drawable.marieantoinette),
            new Noble("regent","purple", 4,R.drawable.regent), new Noble("robespierre","purple", 3,R.drawable.robespierre), new Noble("duke","purple", 3,R.drawable.duke), new Noble("baron","purple", 3,R.drawable.baron), new Noble("lady","purple", 2,R.drawable.lady), new Noble("lord","purple", 2,R.drawable.lord), new Noble("countess","purple", 2,R.drawable.countess),
            new Noble("count","purple", 2,R.drawable.count), new Noble("Fast Noble","purple", 2,R.drawable.fastnoble), new Noble("lady in Waiting","purple", 1,R.drawable.ladyinwaiting), new Noble("Royal Cartographer","purple", 1,R.drawable.royalcartographer), new Noble("coiffeur","purple", 1,R.drawable.coiffeur), new Noble("Piss Boy","purple", 1,R.drawable.pissboy)};


    public BuildNobleDeck()
    {
    }

    public Noble[] getNobleList() {
    return nobleList;
}
}
