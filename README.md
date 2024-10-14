<!--suppress HtmlDeprecatedAttribute -->
<div align="center">
    <img src=".github/assets/banner.png" alt="Creeplets">
</div>

## Features

- **New Entity: Creeplet**
    - Variations from the standard Creeper:
        - **Fuse Time**: Reduced to 10 seconds.
        - **Explosion Radius**: Decreased to 2 blocks.
        - **Movement Speed**: Increased to 0.5.
        - **Max Health**: Decreased to 10.
    - **Drops**: 0-2 Unstable Gunpowder upon death.
    - The fuse time, explosion radius, movement speed, and maximum health are configurable (see below).

- **New Item: Unstable Gunpowder**
    - Dropped by the Creeplet.
    - Used for crafting Unstable TNT.

- **New Block: Unstable TNT**
    - Crafted using Unstable Gunpowder.
        - Follows the same recipe as vanilla TNT, simply replace regular Gunpowder with Unstable Gunpowder.
    - Variations from the standard TNT:
        - **Fuse Time**: Reduced to 10 seconds.
        - **Power**: Random power from 2 to 10.
    - The fuse time and power are configurable (see below).

## Configuration

You can customize the attributes of the Creeplet and Unstable TNT by editing the configuration file located at
`config/creeplets.json5`.

The default configuration is as follows:

```json5
{
  // The time it takes for the Creeplet to explode. Default for vanilla Creeper is '30'.
  "fuseTime": 10,
  // The size of the explosion. Default for vanilla Creeper is '3'.
  "explosionRadius": 2,
  // How fast the Creeplet moves. Default for vanilla Creeper is '0.25'.
  "movementSpeed": 0.5,
  // The maximum health of the Creeplet. Default for vanilla Creeper is '20'.
  "maxHealth": 10.0,
  // The time it takes for the Unstable TNT to explode. Default for vanilla TNT is '80'.
  "tntFuseTime": 10,
  // The minimum power of the Unstable TNT. Vanilla TNT explodes at a power of '4'.
  "tntMinPower": 2.0,
  // The maximum power of the Unstable TNT. Vanilla TNT explodes at a power of '4'.
  "tntMaxPower": 10.0
}
```

## License

[MIT](LICENSE)
