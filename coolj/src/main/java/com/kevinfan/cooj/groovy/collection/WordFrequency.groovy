package com.kevinfan.cooj.groovy.collection

/**
 * Created by kevinjom on 14-9-3.
 */

def determineWordFrequency(text) {
    def tokens = text.tokenize()

    def frequency = [:]
    tokens.each { e -> frequency[e] = frequency.get(e, 0) + 1 }

    return frequency
}

def text = '''
Some readers have opined that Capsule is somehow less standard than OS packages. This is not true, as capsules are stateless executables, and require no installation whatsoever; as such, they don’t even perform the same function as OS packages, which standardize installation. If your application requires some stateful installation (i.e., installation that requires user-guided configuration at install time), then Capsule is not for you. Others have expressed concern over capsules relying on the availability of a Maven repository at runtime. To this I say that, obviously, software comes at different points on an availability/”mission-criticalness” spectrum, and different applications might choose different tradeoffs when it comes to safety vs. convenience. You can create a capsule with no support for automatic upgrades, or a capsule with no external dependencies at all (and embed all dependencies directly in the capsule). You’ll still get automatic choice of a Java runtime and automatic JVM configuration when you launch the capsule. If you do choose to use external Maven dependencies, I think that there is no reason to suspect accidental inclusion of a wrong dependency version – or other such mishaps – any more than when dependency resolution is done at build time. On the contrary: in the former case, the dependencies are explicitly specified in the capsule, and the capsule can be asked to print out its entire dependency tree. Also, if your organization’s Maven release repository is used as a host for capsule artifacts, there is no reason not to treat it as a devops server, and make sure that it’s as available as other servers needed at runtime (especially because Maven repository software isn’t particularly known to crash).
'''

println determineWordFrequency(text)