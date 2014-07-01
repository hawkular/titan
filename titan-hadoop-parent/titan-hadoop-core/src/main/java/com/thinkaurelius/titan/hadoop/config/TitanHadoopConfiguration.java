package com.thinkaurelius.titan.hadoop.config;

import com.thinkaurelius.titan.diskstorage.configuration.ConfigNamespace;
import com.thinkaurelius.titan.diskstorage.configuration.ConfigOption;

public class TitanHadoopConfiguration {

    public static final ConfigNamespace ROOT_NS =
            new ConfigNamespace(null, "h-root", "titan-hadoop configuration root");

    public static final ConfigNamespace TRUNK_NS =
            new ConfigNamespace(new ConfigNamespace(ROOT_NS, "titan", "titan-hadoop namespace"), "hadoop", "titan-hadoop namespace"); // TODO fix descriptions

    public static final ConfigNamespace INPUT_NS =
            new ConfigNamespace(TRUNK_NS, "input", "Input format");

    public static final ConfigOption<String> INPUT_FORMAT = new ConfigOption<String>(
            INPUT_NS, "format",
            "Package and classname of the input format class.  This must implement the Hadoop InputFormat interface.",
            ConfigOption.Type.LOCAL, "current");

    public static final ConfigOption<String> INPUT_LOCATION = new ConfigOption<String>(
            INPUT_NS, "location",
            "Path to the default input file",
            ConfigOption.Type.LOCAL, String.class);

    public static final ConfigNamespace INPUT_CONF_NS =
            new ConfigNamespace(INPUT_NS, "conf", "Settings for the input format class");

    public static final ConfigOption<String> TITAN_INPUT_VERSION = new ConfigOption<String>(
            INPUT_NS, "db-version",
            "The version of the Titan database being read",
            ConfigOption.Type.LOCAL, "current");

    public static final ConfigNamespace OUTPUT_NS =
            new ConfigNamespace(TRUNK_NS, "output", "MapReduce output configuration");

    public static final ConfigOption<String> OUTPUT_FORMAT = new ConfigOption<String>(
            OUTPUT_NS, "format",
            "Package and classname of the output format class.  This must implment the Hadoop OutputFormat interface.",
            ConfigOption.Type.LOCAL, String.class);

    public static final ConfigOption<String> OUTPUT_LOCATION = new ConfigOption<String>(
            OUTPUT_NS, "location",
            "Path to the default output file",
            ConfigOption.Type.LOCAL, String.class);

    public static final ConfigOption<Boolean> OUTPUT_OVERWRITE = new ConfigOption<Boolean>(
            OUTPUT_NS, "overwrite",
            "Whether to overwrite the default output file",
            ConfigOption.Type.LOCAL, true);

    public static final ConfigNamespace OUTPUT_CONF_NS =
            new ConfigNamespace(OUTPUT_NS, "conf", "Settings for the output format class");

    public static final ConfigNamespace PIPELINE_NS =
            new ConfigNamespace(TRUNK_NS, "pipeline", "Titan-Hadoop pipeline configuration");

    public static final ConfigOption<Boolean> PIPELINE_TRACK_STATE = new ConfigOption<Boolean>(
            PIPELINE_NS, "track-state",
            "Whether to keep intermediate state information",
            ConfigOption.Type.LOCAL, false);

    public static final ConfigOption<Boolean> PIPELINE_TRACK_PATHS = new ConfigOption<Boolean>(
            PIPELINE_NS, "track-paths",
            "Whether to keep intermediate traversal path information",
            ConfigOption.Type.LOCAL, false);

    public static final ConfigOption<Integer> PIPELINE_MAP_SPILL_OVER = new ConfigOption<Integer>(
            PIPELINE_NS, "map-spill-over",
            "The maximum number of map entries held in memory during computation; maps that grow past this entry limit will be partially written to disk",
            ConfigOption.Type.LOCAL, 500);

    public static final ConfigNamespace SIDE_EFFECT_NS =
            new ConfigNamespace(TRUNK_NS, "sideeffect", "Titan-Hadoop side effect output configuration");

    public static final ConfigOption<String> SIDE_EFFECT_FORMAT = new ConfigOption<String>(
            SIDE_EFFECT_NS, "format",
            "Package and classname of the output format to use for computation side effects.  This must implement the Hadoop OutputFormat interface.",
            ConfigOption.Type.LOCAL, String.class);
}