/**
 * Sample React Native App
 * https://github.com/facebook/react-native
 *
 * Generated with the TypeScript template
 * https://github.com/react-native-community/react-native-template-typescript
 *
 * @format
 */

import React, { useRef, useState } from 'react'
import { Button, findNodeHandle, StyleSheet, View } from 'react-native'
import { DEFAULT_INT_VALUE, DEFAULT_STRING_VALUE, RainbowView, start, stop } from './RainbowView'

const App = () => {
  const [started, setStarted] = useState(false)
  const rainbowViewRef = useRef(null)

  console.log(`DEFAULT_INT_VALUE = ${DEFAULT_INT_VALUE}`)
  console.log(`DEFAULT_STRING_VALUE = ${DEFAULT_STRING_VALUE}`)

  return (
    <View style={styles.container}>
      <Button
        title={started ? 'stop' : 'start'}
        onPress={() => {
          const viewId = findNodeHandle(rainbowViewRef.current)
          if (started) {
            stop(viewId)
            setStarted(false)
          } else {
            start(viewId)
            setStarted(true)
          }
        }}
      />
      <RainbowView
        ref={rainbowViewRef}
        updateMillis={2000}
        style={styles.rainbow}
        onColorChanged={e =>
          console.log('color changed: ', e.nativeEvent.color)
        }
      />
    </View>
  )
}
const styles = StyleSheet.create({
  container: {
    flex: 1,
  },
  rainbow: {
    width: '100%',
    height: '100%',
  },
})

export default App
