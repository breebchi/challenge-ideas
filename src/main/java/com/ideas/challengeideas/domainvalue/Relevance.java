package com.ideas.challengeideas.domainvalue;

public enum Relevance
{
    HOT("HOT"), STANDARD("STANDARD"), BORING("BORING");

    public final String relevance;


    Relevance(String relevance)
    {
        this.relevance = relevance;
    }


    public static Relevance fromString(String relevance)
    {
        for (Relevance c : Relevance.values())
        {
            if (c.relevance.equalsIgnoreCase(relevance))
            {
                return c;
            }
        }
        return null;
    }


    public String getRelevance()
    {
        return this.relevance;
    }
}
