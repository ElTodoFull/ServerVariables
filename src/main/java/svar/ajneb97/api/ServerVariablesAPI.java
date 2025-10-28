package svar.ajneb97.api;

import svar.ajneb97.ServerVariables;
import svar.ajneb97.model.ListVariableResult;
import svar.ajneb97.model.StringVariableResult;
import svar.ajneb97.model.ServerVariablesPlayer;
import svar.ajneb97.model.structure.ListVariable;
import svar.ajneb97.model.structure.StringVariable;

import java.util.List;
import java.util.UUID;

public class ServerVariablesAPI {

    private static ServerVariables plugin;
    public ServerVariablesAPI(ServerVariables plugin) {
        this.plugin = plugin;
    }

    public static StringVariableResult getVariableValue(UUID uuid, String variableName){
        return plugin.getPlayerVariablesManager().getVariableValue(uuid, variableName, false);
    }

    public static StringVariableResult getVariableValue(String playerName, String variableName){
        return plugin.getPlayerVariablesManager().getVariableValue(playerName, variableName, false);
    }

    public static StringVariableResult getVariableValue(String variableName){
        return plugin.getVariablesManager().getVariableValue(null, variableName, false);
    }

    public static String getVariableDisplay(String playerName, String variableName){
        StringVariableResult result = plugin.getVariablesManager().getVariableValue(playerName,variableName,false);
        if(result.getVariable() != null){
            return plugin.getVariablesManager().getDisplayFromVariableValue(result.getVariable(),result.getResultValue());
        }
        return result.getResultValue();
    }

    public static String getVariableDisplay(String variableName){
        StringVariableResult result = plugin.getVariablesManager().getVariableValue(null,variableName,false);
        if(result.getVariable() != null){
            return plugin.getVariablesManager().getDisplayFromVariableValue(result.getVariable(),result.getResultValue());
        }
        return result.getResultValue();
    }

    public static StringVariableResult setVariableValue(String variableName, String value){
        return plugin.getVariablesManager().setVariableValue(null,variableName,value);
    }

    public static StringVariableResult setVariableValue(UUID uuid, String variableName, String value){
        return plugin.getPlayerVariablesManager().setVariable(uuid,variableName,value);
    }

    public static StringVariableResult setVariableValue(String playerName, String variableName, String value){
        return plugin.getPlayerVariablesManager().setVariable(playerName,variableName,value);
    }

    public static StringVariableResult getListVariableValueAtIndex(UUID uuid, String variableName, int index){
        return plugin.getPlayerVariablesManager().getListVariableValueAtIndex(uuid, variableName, index);
    }

    public static StringVariableResult getListVariableValueAtIndex(String playerName, String variableName, int index){
        return plugin.getPlayerVariablesManager().getListVariableValueAtIndex(playerName, variableName, index);
    }

    public static StringVariableResult getListVariableValueAtIndex(String variableName, int index){
        return plugin.getVariablesManager().getListVariablesManager().getListVariableValueAtIndex(null, variableName, index);
    }

    public static String getListVariableDisplayAtIndex(String playerName, String variableName, int index){
        StringVariableResult result = plugin.getVariablesManager().getListVariablesManager().getListVariableValueAtIndex(playerName,variableName,index);
        if(result.getVariable() != null){
            return plugin.getVariablesManager().getDisplayFromVariableValue(result.getVariable(),result.getResultValue());
        }
        return result.getResultValue();
    }

    public static String getListVariableDisplayAtIndex(String variableName, int index){
        StringVariableResult result = plugin.getVariablesManager().getListVariablesManager().getListVariableValueAtIndex(null,variableName,index);
        if(result.getVariable() != null){
            return plugin.getVariablesManager().getDisplayFromVariableValue(result.getVariable(),result.getResultValue());
        }
        return result.getResultValue();
    }

    public static StringVariableResult setListVariableValueAtIndex(String variableName, int index, String value){
        return plugin.getVariablesManager().getListVariablesManager().setListVariableValue(null,variableName,index,value,false);
    }

    public static StringVariableResult setListVariableValueAtIndex(UUID uuid, String variableName, int index, String value){
        return plugin.getPlayerVariablesManager().setListVariableAtIndex(uuid,variableName,index,value);
    }

    public static StringVariableResult setListVariableValueAtIndex(String playerName, String variableName, int index, String value){
        return plugin.getPlayerVariablesManager().setListVariableAtIndex(playerName,variableName,index,value);
    }

    public static int getListVariableLength(UUID uuid, String variableName){
        ListVariableResult result = plugin.getPlayerVariablesManager().getListVariableValue(uuid, variableName);
        if(result.isError() || result.getResultValue() == null){
            return 0;
        }
        return result.getResultValue().size();
    }

    public static int getListVariableLength(String playerName, String variableName){
        ListVariableResult result = plugin.getPlayerVariablesManager().getListVariableValue(playerName, variableName);
        if(result.isError() || result.getResultValue() == null){
            return 0;
        }
        return result.getResultValue().size();
    }

    public static int getListVariableLength(String variableName){
        ListVariableResult result = plugin.getVariablesManager().getListVariablesManager().getListVariableValue(null, variableName, false);
        if(result.isError() || result.getResultValue() == null){
            return 0;
        }
        return result.getResultValue().size();
    }

    public static ServerVariablesPlayer getPlayerByName(String playerName){
        return plugin.getPlayerVariablesManager().getPlayerByName(playerName);
    }

    public static ServerVariablesPlayer getPlayerByUUID(UUID uuid){
        return plugin.getPlayerVariablesManager().getPlayerByUUID(uuid);
    }

    public static String getStringVariableInitialValue(String variableName){
        StringVariable variable = (StringVariable) plugin.getVariablesManager().getVariable(variableName);
        if(variable == null){
            return null;
        }
        return variable.getInitialValue();
    }

    public static List<String> getListVariableInitialValue(String variableName){
        ListVariable variable = (ListVariable) plugin.getVariablesManager().getVariable(variableName);
        if(variable == null){
            return null;
        }
        return variable.getInitialValue();
    }

    public static boolean listVariableContainsValue(String playerName, String variableName,String value){
        ListVariableResult result = plugin.getPlayerVariablesManager().getListVariableValue(playerName, variableName);
        if(result.isError() || result.getResultValue() == null){
            return false;
        }
        return result.getResultValue().contains(value);
    }

    public static boolean listVariableContainsValue(String variableName,String value){
        ListVariableResult result = plugin.getVariablesManager().getListVariablesManager().getListVariableValue(null, variableName, false);
        if(result.isError() || result.getResultValue() == null){
            return false;
        }
        return result.getResultValue().contains(value);
    }

    /**
     * Gets all values from a global list variable joined by a separator
     * @param variableName The name of the list variable
     * @param separator The separator to use between values
     * @return StringVariableResult containing the joined string or error
     */
    public static StringVariableResult getListVariableValueAll(String variableName, String separator) {
        return plugin.getVariablesManager().getListVariablesManager().getListVariableValueAll(null, variableName, separator);
    }
    
    /**
     * Gets all values from a player's list variable joined by a separator
     * @param playerName The name of the player
     * @param variableName The name of the list variable
     * @param separator The separator to use between values
     * @return StringVariableResult containing the joined string or error
     */
    public static StringVariableResult getListVariableValueAll(String playerName, String variableName, String separator) {
        return plugin.getVariablesManager().getListVariablesManager().getListVariableValueAll(playerName, variableName, separator);
    }
}
