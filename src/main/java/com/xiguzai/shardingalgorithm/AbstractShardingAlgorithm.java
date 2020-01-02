package com.xiguzai.shardingalgorithm;

import java.io.Serializable;
import java.util.Collection;
import java.util.Optional;
import java.util.Set;

/**
 * AbstractShardingAlgorithm
 *
 * @author xiguzai
 */
public abstract class AbstractShardingAlgorithm<T extends Serializable> {

    protected static final String SPLIT = "_";

    /**
     * getRouteTableName
     *
     * @param availableTargetNames
     * @param logicTableName
     * @param columnName
     * @param value
     * @return
     */
    abstract Optional<String> getRouteTableName(Collection<String> availableTargetNames, String logicTableName, String columnName, T value);

    protected void addTargetNames(Set<String> targetNames, Collection<String> availableTargetNames, String logicTableName, String columnName, T value) {
        Optional<String> routeTableName = getRouteTableName(availableTargetNames, logicTableName, columnName, value);
        routeTableName.ifPresent(targetNames::add);
    }
}