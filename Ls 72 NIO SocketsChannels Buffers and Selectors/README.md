## References: 
- https://medium.com/@adityakulrajdtu/socket-programming-using-java-nio-42b19a3b458c
- https://jenkov.com/tutorials/java-nio/selectors.html
- https://youtu.be/h76n2R4HRts?si=nBOYbwmxax5JDUTC
  
# Socket Programming Using JAVA NIO
Sockets are endpoints to perform two-way communication by TCP and UDP protocols.   
Java sockets APIs are adapters for the corresponding functionality of the operating systems.  
Sockets communication in POSIX-compliant operating systems (Unix, Linux, Mac OS X, BSD, Solaris, AIX, etc.) is performed by Berkeley sockets.  

JAVA Non-Blocking I/O is widely used in socket programming where a client and server can bind to a port or a socket to exchange messages through a shared buffer. 

Java NIO (New I/O) is an alternative to the traditional I/O API provided by Java for socket programming. 
It was introduced in Java 1.4 to provide a more scalable and efficient approach to handle I/O operations.

Java NIO is built around non-blocking **Channels**, **Selectors**, and **Buffers**.

**Non-blocking I/O**: Java NIO is based on a non-blocking I/O model, which means that multiple I/O operations can be managed by a single thread. This allows you to handle multiple connections simultaneously without the need for a thread per connection, resulting in better scalability and reduced resource consumption.

Here is a great video explaining the non-blocking I/O model: https://youtu.be/wB9tIg209-8?si=ZLUKEEckx5fXrW7G

A **Channel** (e.g. SocketChannel) represents an open connection to an entity like a file or network socket.
- `SocketChannel` (for TCP client connections)
- `ServerSocketChannel` (for TCP server sockets)
- `DatagramChannel` (for UDP sockets)

Channels can generally be used for both reading and writing. Unlike traditional InputStream/OutputStream, channels can be configured to operate in non-blocking mode.

In blocking I/O (the traditional InputStream/OutputStream), if you try to read data and no data is available, the call will block (pause) until data arrives.
In non-blocking I/O, if no data is available, the call will return immediately, usually with a return value like 0 or -1 (depending on the method), indicating that nothing could be done at the moment.

```java
SocketChannel channel = SocketChannel.open();
channel.configureBlocking(false); // <-- Non-blocking mode

ByteBuffer buffer = ByteBuffer.allocate(1024);
int bytesRead = channel.read(buffer); // returns immediately

if (bytesRead == 0) {
    System.out.println("No data available right now.");
}
```

In non-blocking mode, when you call a method like channel.read(buffer), the channel checks the underlying OS socket buffer to see if any data is available at that exact moment. If there’s nothing to read, it simply returns 0 (or -1 if the end of stream is reached).

But doing this check repeatedly in a loop (called polling) is inefficient. That’s where the Selector comes in.

![](https://jenkov.com/images/java-nio/overview-selectors.png)

**Selectors**: Java NIO introduces the concept of selectors, which allows a single thread to monitor multiple channels for I/O events. With selectors, you can efficiently manage multiple network connections

In short, a Selector multiplexes I/O—it lets one thread manage thousands of non-blocking sockets efficiently.

With a Selector, one thread can manage hundreds or thousands of sockets using non-blocking I/O, drastically reducing the number of threads and CPU usage.

Switching between threads is expensive for an operating system, and each thread takes up some resources (memory) in the operating system too. Therefore, the less threads you use, the better.

In order to use a Channel with a Selector you must register the Channel with the Selector. This is done using the SelectableChannel.register() method, like this:
```java
Selector selector = Selector.open();
SocketChannel channel = SocketChannel.open();
channel.configureBlocking(false);
channel.register(selector, SelectionKey.OP_READ); // Watch for "read ready"
```

> Note: The Channel must be in non-blocking mode to be used with a Selector. This means that you cannot use FileChannel's with a Selector since FileChannel's cannot be switched into non-blocking mode. Socket channels will work fine though.

A **SelectionKey** represents the registration of a Channel with a Selector. It’s like a ticket or handle that connects a Channel to a Selector, and it keeps track of:
- Which operations you're interested in (e.g. read, write, connect)
- Which operations are currently ready (e.g. is the channel readable right now?)
- The Channel itself
- Optionally, an attachment (any object you want to associate with the key)

Notice the second parameter of the `register()` method. This is an "**interest set**", meaning what events you are interested in listening for in the Channel, via the Selector. There are four different events you can listen for:
- Connect
- Accept
- Read
- Write

A channel that "fires an event" is also said to be "ready" for that event. So, a channel that has connected successfully to another server is "connect ready". A server socket channel which accepts an incoming connection is "accept" ready. A channel that has data ready to be read is "read" ready. A channel that is ready for you to write data to it, is "write" ready.
These four events are represented by the four SelectionKey constants:
- SelectionKey.OP_CONNECT
- SelectionKey.OP_ACCEPT
- SelectionKey.OP_READ
- SelectionKey.OP_WRITE

If you are interested in more than one event, OR the constants together, like this:
```java
int interestSet = SelectionKey.OP_READ | SelectionKey.OP_WRITE;    
```

The **Ready Set** is the set of operations the channel is ready for. You will primarily be accessing the ready set after a selection. Selection is explained in a later section. You access the ready set like this:
```java
int readySet = selectionKey.readyOps();
```
You can test in the same way as with the interest set, what events / operations the channel is ready for. But, you can also use these four methods instead, which all return a boolean:
```java
selectionKey.isAcceptable();
selectionKey.isConnectable();
selectionKey.isReadable();
selectionKey.isWritable();
```

You can iterate this selected key set to access the ready channels.
```java
// This gets the set of keys representing channels that are ready.
Set<SelectionKey> selectedKeys = selector.selectedKeys();


for (SelectionKey key : selectedKeys) {
    if (key.isReadable()) {
        // Channel is ready for reading
    }
}
selectedKeys.clear(); // Clear processed keys
```
> You must clear the set after processing it. If not, you'll keep processing the same events again and again.

Visual Representation of Selectors and Channels   

![](https://miro.medium.com/v2/resize:fit:1100/format:webp/0*_sZNH61bc7bwk0x1.jpg)


**Buffer-oriented operations**: Java NIO uses buffers for reading from and writing to channels. Buffers provide a more flexible and efficient way to manage data, allowing you to perform bulk data transfers between channels and buffers.

They are a fixed-size block of memory used for reading from or writing to channels.
Unlike traditional streams that read/write one byte at a time, NIO reads/writes data in bulk, using buffers.

Commonly used type is `ByteBuffer`
```java
ByteBuffer buffer = ByteBuffer.allocate(1024); // 1 KB buffer
```

Why are Buffers used?  
Java NIO channels (like SocketChannel or FileChannel) do not work with arrays or primitive types directly. Instead, they read data into buffers and write data from buffers.

In Java NIO, Channel objects don't deal with raw bytes directly.
You read data from a Channel **into a ByteBuffer**, and you **write** data **from** a `ByteBuffer` **to a Channel**.
Therefore:   
READ: Channel -> ByteBuffer  
WRITE: ByteBuffer -> Channel  

Common Buffer Operations
```java
ByteBuffer buffer = ByteBuffer.allocate(1024);

// Read data from a channel
int bytesRead = channel.read(buffer);
/*
 The channel.read(buffer) method puts data into the buffer’s internal array, starting from buffer.position()
 It updates buffer.position() to reflect the number of bytes read.       
*/

// Switch from writing mode (into buffer) to reading mode (from buffer)
buffer.flip();

while (buffer.hasRemaining()) {
byte b = buffer.get();
// Process the byte
}

// Prepare buffer for writing again
buffer.clear(); // or buffer.compact()
```
