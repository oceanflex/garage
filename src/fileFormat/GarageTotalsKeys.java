package fileFormat;

/**
 *
 * @author zsummers
 */
public enum GarageTotalsKeys {
    
    TIME {@Override public String toString(){return "Hours Parked";}
    },
    MONEY {@Override public String toString(){return "Dollars Collected";}
    },
    PARKED {@Override public String toString(){return "Vehicles in Lot";}
    },
    PAYED {@Override public String toString(){return "Vehicles that Exited";}
    }
}
